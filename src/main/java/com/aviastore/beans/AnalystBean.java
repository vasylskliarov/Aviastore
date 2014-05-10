package com.aviastore.beans;

import java.io.Serializable;
import java.util.*;

import javax.inject.Named;

import org.primefaces.model.chart.*;
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
	

	private CartesianChartModel chartModelByDate;
	private PieChartModel chartModelByPlace;


	public AnalystBean() {}
	
	public void generateReports() {
		this.generateReportByDate();
		this.generateReportByPlace();
		if (repByDateList.size() > 0){
			this.showByDate = true;
			this.createChartModelByDate();
			this.createChartModelByPlace();

			
			
			
		}
	}

//	private void createModelByPlace() {
//		modelByPlace = new CartesianChartModel();
//		ChartSeries quantitySeries = new ChartSeries();
//		quantitySeries.setLabel("Quantities");
//		for (Report rp :repByPlaceList) {
//			quantitySeries.set(rp.getOrigin()+"-"+rp.getDestination(), rp.getQuantity());
//		}
//		ChartSeries priceSeries = new ChartSeries();
//		priceSeries.setLabel("Price");
//		for (Report rp : repByPlaceList) {
//			priceSeries.set(rp.getOrigin()+"-"+rp.getDestination(), rp.getTotal());
//		}
//		modelByPlace.addSeries(priceSeries);
//		modelByPlace.addSeries(quantitySeries);	
//	}

//	Андрея
	/* private void createChartByPlace() {

		  if (this.listDestFromPeriod != null) {
		   chartByPlace = new PieChartModel();

		   for (HDateDestTicketSumDao element : ReportByPlace) {
		    chartByPlace.set(element.getDestPlace() + " " + element.getTotalSum(), element.getAmountOfTickets());
		   }
		  }
		 }*/
	
	
	
	
	public void createChartModelByPlace(){
		chartModelByPlace = new PieChartModel();
		for (Report rp : repByPlaceList) {
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n\n"+rp );
			chartModelByPlace.set(rp.getOrigin()+"-"+rp.getDestination(), rp.getTotal());
		   }
		
	}
	


	
	
	public void createChartModelByDate(){
		chartModelByDate = new CartesianChartModel();
		 LineChartSeries sum = new LineChartSeries();
		 sum.setLabel("Sum");
		 for (Report rp : repByDateList) {
				System.out.println("____________________________________________________________________\n\n\n"+rp );
			    sum.set(rp.getDate(), rp.getTotal());
			   }
		 chartModelByDate.addSeries(sum);
		
		
	}
	
	
	
	public CartesianChartModel getChartModelByDate() {
		return chartModelByDate;
	}

	public void setChartModelByDate(CartesianChartModel chartModelByDate) {
		this.chartModelByDate = chartModelByDate;
	}
	
	public PieChartModel getChartModelByPlace() {
		return chartModelByPlace;
	}

	public void setChartModelByPlace(PieChartModel chartModelByPlace) {
		this.chartModelByPlace = chartModelByPlace;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
