package com.bhargrah.energymart.model;

import java.time.ZonedDateTime;
import java.util.Objects;

public class UserAccount {
    private Integer id;
    private String meterId;
    private String planId;
    private ZonedDateTime userJoinDate;
    private String accountType;
    private String accountStatus;

    public UserAccount(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public UserAccount setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getMeterId() {
        return meterId;
    }

    public UserAccount setMeterId(String meterId) {
        this.meterId = meterId;
        return this;
    }

    public String getPlanId() {
        return planId;
    }

    public UserAccount setPlanId(String planId) {
        this.planId = planId;
        return this;
    }

    public ZonedDateTime getUserJoinDate() {
        return userJoinDate;
    }

    public UserAccount setUserJoinDate(ZonedDateTime userJoinDate) {
        this.userJoinDate = userJoinDate;
        return this;
    }

    public String getAccountType() {
        return accountType;
    }

    public UserAccount setAccountType(String accountType) {
        this.accountType = accountType;
        return this;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public UserAccount setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAccount that = (UserAccount) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(meterId, that.meterId) &&
                Objects.equals(planId, that.planId) &&
                Objects.equals(userJoinDate, that.userJoinDate) &&
                Objects.equals(accountType, that.accountType) &&
                Objects.equals(accountStatus, that.accountStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, meterId, planId, userJoinDate, accountType, accountStatus);
    }

    @Override
    public String toString() {
        return "\n UserAccount{" +
                "\n\t\t\t id=" + id +
                "\n\t\t\t meterId='" + meterId + '\'' +
                "\n\t\t\t planId='" + planId + '\'' +
                "\n\t\t\t userJoinDate=" + userJoinDate +
                "\n\t\t\t accountType='" + accountType + '\'' +
                "\n\t\t\t accountStatus='" + accountStatus + '\'' +
                "\n\t\t\t }";
    }
}
