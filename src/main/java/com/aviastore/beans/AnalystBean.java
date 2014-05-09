package com.aviastore.beans;

import java.io.Serializable;
import java.util.*;

import javax.inject.Named;

import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.aviastore.entitys.*;
import com.aviastore.services.*;

@Named
@Component
@Scope("session")
public class AnalystBean implements Serializable {
	private static final long serialVersionUID = 1L;
	@Autowired 
	OrdersServices ordersServices;

	private Date startDate;
	private Date endDate;

	private List<Report> repByDateList;
	private List<Report> repByPlaceList;

	private boolean showByDate = false;
	private boolean showByPlace = false;

	private CartesianChartModel modelByDate = new CartesianChartModel();
	private CartesianChartModel modelByPlace;
	
	public AnalystBean() {}
	
	public void generateReports() {
		this.generateReportByDate();
		this.generateReportByPlace();
		if (repByDateList.size() > 0){
			this.showByDate = true;
			this.createModelByDate();
			this.createModelByPlace();
		}
	}

	private void createModelByPlace() {
		System.out.println("!!!modelPlaceCreating!!!");
		modelByPlace = new CartesianChartModel();
		ChartSeries quantitySeries = new ChartSeries();
		quantitySeries.setLabel("Quantities");
		for (Report rp :repByPlaceList) {
			quantitySeries.set(rp.getOrigin()+"-"+rp.getDestination(), rp.getQuantity());
		}
		ChartSeries priceSeries = new ChartSeries();
		priceSeries.setLabel("Price");
		for (Report rp : repByPlaceList) {
			priceSeries.set(rp.getOrigin()+"-"+rp.getDestination(), rp.getTotal());
		}
		modelByPlace.addSeries(priceSeries);
		modelByPlace.addSeries(quantitySeries);	
	}

	private void createModelByDate() {
		System.out.println("~~modelCreating~~");
		modelByDate = new CartesianChartModel();
		ChartSeries quantitySeries = new ChartSeries();
		quantitySeries.setLabel("Quantities");
		for (Report rp : repByDateList) {
			quantitySeries.set(rp.getDate(), rp.getQuantity());
		}
		ChartSeries priceSeries = new ChartSeries();
		priceSeries.setLabel("Price");
		for (Report rp : repByDateList) {
			priceSeries.set(rp.getDate(), rp.getTotal());
		}
		modelByDate.addSeries(priceSeries);
		modelByDate.addSeries(quantitySeries);
	}
	
	public void generateReportByDate() {
		if (startDate == null || endDate == null) {
			return;
		}
		this.repByDateList = ordersServices.getStatByDates(startDate, endDate);
	}

	public void generateReportByPlace() {
		if (startDate == null || endDate == null) {
			return;
		}
		this.repByPlaceList = ordersServices.getStatByCitys(startDate, endDate);
	}

	public OrdersServices getOrdersServices() {
		return ordersServices;
	}

	public void setOrdersServices(OrdersServices ordersServices) {
		this.ordersServices = ordersServices;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public List<Report> getRepByDateList() {
		return repByDateList;
	}

	public void setRepByDateList(List<Report> repByDateList) {
		this.repByDateList = repByDateList;
	}

	public List<Report> getRepByPlaceList() {
		return repByPlaceList;
	}

	public void setRepByPlaceList(List<Report> repByPlaceList) {
		this.repByPlaceList = repByPlaceList;
	}

	public boolean isShowByDate() {
		return showByDate;
	}

	public void setShowByDate(boolean showByDate) {
		this.showByDate = showByDate;
	}

	public boolean isShowByPlace() {
		return showByPlace;
	}

	public void setShowByPlace(boolean showByPlace) {
		this.showByPlace = showByPlace;
	}

	public CartesianChartModel getModelByDate() {
		return modelByDate;
	}

	public void setModelByDate(CartesianChartModel modelByDate) {
		this.modelByDate = modelByDate;
	}

	public CartesianChartModel getModelByPlace() {
		return modelByPlace;
	}

	public void setModelByPlace(CartesianChartModel modelByPlace) {
		this.modelByPlace = modelByPlace;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
