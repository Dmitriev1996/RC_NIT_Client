/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.entity;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class ContractOrderYurface {
    private int ContractsOrdersYurfaces_ID;
    private Date DateContract;
    private int AppTeach_ID;
    private int Yur_ID;
    private int Cource_ID;
    private String NameOrganization;
    private String Cource;
    private String TypeContract;
    private int TypeContract_ID;
    private String PayType;
    private int PayType_ID;
    private Date DateBegin;
    private Date DateEnd;
    private double Price;
    private String PayPeriod;
    private int PayPeriod_ID;
    private double SumPay;
    private double SumYear;
    private String DetailsContract;
    private String Comment;
    private byte CloseContract;

    public int getContractsOrdersYurfaces_ID() {
        return ContractsOrdersYurfaces_ID;
    }

    public void setContractsOrdersYurfaces_ID(int ContractsOrdersYurfaces_ID) {
        this.ContractsOrdersYurfaces_ID = ContractsOrdersYurfaces_ID;
    }

    public Date getDateContract() {
        return DateContract;
    }

    public void setDateContract(Date DateContract) {
        this.DateContract = DateContract;
    }

    public String getNameOrganization() {
        return NameOrganization;
    }

    public void setNameOrganization(String NameOrganization) {
        this.NameOrganization = NameOrganization;
    }

    public String getCource() {
        return Cource;
    }

    public void setCource(String Cource) {
        this.Cource = Cource;
    }

    public String getTypeContract() {
        return TypeContract;
    }

    public void setTypeContract(String TypeContract) {
        this.TypeContract = TypeContract;
    }

    public String getPayType() {
        return PayType;
    }

    public void setPayType(String PayType) {
        this.PayType = PayType;
    }

    public Date getDateBegin() {
        return DateBegin;
    }

    public void setDateBegin(Date DateBegin) {
        this.DateBegin = DateBegin;
    }

    public Date getDateEnd() {
        return DateEnd;
    }

    public void setDateEnd(Date DateEnd) {
        this.DateEnd = DateEnd;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public String getPayPeriod() {
        return PayPeriod;
    }

    public void setPayPeriod(String PayPeriod) {
        this.PayPeriod = PayPeriod;
    }

    public double getSumPay() {
        return SumPay;
    }

    public void setSumPay(double SumPay) {
        this.SumPay = SumPay;
    }

    public double getSumYear() {
        return SumYear;
    }

    public void setSumYear(double SumYear) {
        this.SumYear = SumYear;
    }

    public String getDetailsContract() {
        return DetailsContract;
    }

    public void setDetailsContract(String DetailsContract) {
        this.DetailsContract = DetailsContract;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String Comment) {
        this.Comment = Comment;
    }

    public byte getCloseContract() {
        return CloseContract;
    }

    public void setCloseContract(byte CloseContract) {
        this.CloseContract = CloseContract;
    }

	public int getAppTeach_ID() {
		return AppTeach_ID;
	}

	public void setAppTeach_ID(int appTeach_ID) {
		AppTeach_ID = appTeach_ID;
	}

	public int getYur_ID() {
		return Yur_ID;
	}

	public void setYur_ID(int yur_ID) {
		Yur_ID = yur_ID;
	}

	public int getCource_ID() {
		return Cource_ID;
	}

	public void setCource_ID(int cource_ID) {
		Cource_ID = cource_ID;
	}

	public int getTypeContract_ID() {
		return TypeContract_ID;
	}

	public void setTypeContract_ID(int typeContract_ID) {
		TypeContract_ID = typeContract_ID;
	}

	public int getPayType_ID() {
		return PayType_ID;
	}

	public void setPayType_ID(int payType_ID) {
		PayType_ID = payType_ID;
	}

	public int getPayPeriod_ID() {
		return PayPeriod_ID;
	}

	public void setPayPeriod_ID(int payPeriod_ID) {
		PayPeriod_ID = payPeriod_ID;
	}
    
    

 
    
}
