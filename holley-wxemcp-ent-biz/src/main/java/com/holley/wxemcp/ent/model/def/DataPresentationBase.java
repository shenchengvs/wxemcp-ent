package com.holley.wxemcp.ent.model.def;

public class DataPresentationBase {

    private double                     owingmoney     = 0;
    private double                     remainingmoney = 0;
    private int                        owingusers;
    private RechargeMoneyBlock         rechargeMoneyBlock;
    private EventCountBlock            eventCountBlock;
    private ElectricalConsumptionBlock electricalConsumptionBlock;
    private EnergyUserBlock            energyUserBlock;
    private DepartmentUseBlock         departmentUseBlock;

    public RechargeMoneyBlock getRechargeMoneyBlock() {
        return rechargeMoneyBlock;
    }

    public void setRechargeMoneyBlock(RechargeMoneyBlock rechargeMoneyBlock) {
        this.rechargeMoneyBlock = rechargeMoneyBlock;
    }

    public EventCountBlock getEventCountBlock() {
        return eventCountBlock;
    }

    public void setEventCountBlock(EventCountBlock eventCountBlock) {
        this.eventCountBlock = eventCountBlock;
    }

    public ElectricalConsumptionBlock getElectricalConsumptionBlock() {
        return electricalConsumptionBlock;
    }

    public void setElectricalConsumptionBlock(ElectricalConsumptionBlock electricalConsumptionBlock) {
        this.electricalConsumptionBlock = electricalConsumptionBlock;
    }

    public EnergyUserBlock getEnergyUserBlock() {
        return energyUserBlock;
    }

    public void setEnergyUserBlock(EnergyUserBlock energyUserBlock) {
        this.energyUserBlock = energyUserBlock;
    }

    public DepartmentUseBlock getDepartmentUseBlock() {
        return departmentUseBlock;
    }

    public void setDepartmentUseBlock(DepartmentUseBlock departmentUseBlock) {
        this.departmentUseBlock = departmentUseBlock;
    }

    public double getOwingmoney() {
        return Math.abs(owingmoney);
    }

    public void setOwingmoney(double owingmoney) {
        this.owingmoney = owingmoney;
    }

    public double getRemainingmoney() {
        return remainingmoney;
    }

    public void setRemainingmoney(double remainingmoney) {
        this.remainingmoney = remainingmoney;
    }

    public int getOwingusers() {
        return owingusers;
    }

    public void setOwingusers(int owingusers) {
        this.owingusers = owingusers;
    }
}
