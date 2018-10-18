package logic.entity;

import java.sql.Date;

public class OrderAdmission {
	private int OrderAdmission_ID;
    private int ContractsOrdersPhysfaces_ID;
    private ContractOrderPhysface ContractOrderPhysface;
    private int ContractsOrdersYurfaces_ID;
    private ContractOrderYurface ContractOrderYurface;
    private String Cource;
    private Date DateBeginScience;
    private Date DateEndScience;
    private int Teacher_ID;
    private String Teacher;
    private int StatusOrder_ID;
    private String StatusOrder;
	public int getOrderAdmission_ID() {
		return OrderAdmission_ID;
	}
	public void setOrderAdmission_ID(int orderAdmission_ID) {
		OrderAdmission_ID = orderAdmission_ID;
	}
	public int getContractsOrdersPhysfaces_ID() {
		return ContractsOrdersPhysfaces_ID;
	}
	public void setContractsOrdersPhysfaces_ID(int contractsOrdersPhysfaces_ID) {
		ContractsOrdersPhysfaces_ID = contractsOrdersPhysfaces_ID;
	}
	public ContractOrderPhysface getContractOrderPhysface() {
		return ContractOrderPhysface;
	}
	public void setContractOrderPhysface(ContractOrderPhysface contractOrderPhysface) {
		ContractOrderPhysface = contractOrderPhysface;
	}
	public int getContractsOrdersYurfaces_ID() {
		return ContractsOrdersYurfaces_ID;
	}
	public void setContractsOrdersYurfaces_ID(int contractsOrdersYurfaces_ID) {
		ContractsOrdersYurfaces_ID = contractsOrdersYurfaces_ID;
	}
	public ContractOrderYurface getContractOrderYurface() {
		return ContractOrderYurface;
	}
	public void setContractOrderYurface(ContractOrderYurface contractOrderYurface) {
		ContractOrderYurface = contractOrderYurface;
	}
	public String getCource() {
		return Cource;
	}
	public void setCource(String cource) {
		Cource = cource;
	}
	public Date getDateBeginScience() {
		return DateBeginScience;
	}
	public void setDateBeginScience(Date dateBeginScience) {
		DateBeginScience = dateBeginScience;
	}
	public Date getDateEndScience() {
		return DateEndScience;
	}
	public void setDateEndScience(Date dateEndScience) {
		DateEndScience = dateEndScience;
	}
	public int getTeacher_ID() {
		return Teacher_ID;
	}
	public void setTeacher_ID(int teacher_ID) {
		Teacher_ID = teacher_ID;
	}
	public String getTeacher() {
		return Teacher;
	}
	public void setTeacher(String teacher) {
		Teacher = teacher;
	}
	public int getStatusOrder_ID() {
		return StatusOrder_ID;
	}
	public void setStatusOrder_ID(int statusOrder_ID) {
		StatusOrder_ID = statusOrder_ID;
	}
	public String getStatusOrder() {
		return StatusOrder;
	}
	public void setStatusOrder(String statusOrder) {
		StatusOrder = statusOrder;
	}
    
    

}
