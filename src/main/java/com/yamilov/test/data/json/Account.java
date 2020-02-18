package com.yamilov.test.data.json;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class Account {
    @SerializedName("design_url")
    private String designUrl;
    @SerializedName("transactions_total_amount")
    private int transactionsTotalAmount;
    @SerializedName("tariff_avg_month_balance")
    private int tariffAvgMonthBalance;
    @SerializedName("type")
    private int type;
    @SerializedName("closing_date")
    private LocalDateTime closingDate;
    @SerializedName("partial_withdraw_available")
    private int partialWithdrawAvailable;
    @SerializedName("refill_available")
    private int refillAvailable;
    @SerializedName("blocked_amount")
    private BigDecimal blockedAmount;
    @SerializedName("scheme_id")
    private String schemeId;
    @SerializedName("pan")
    private String pan;
    @SerializedName("account_id")
    private int accountId;
    @SerializedName("title_small")
    private String titleSmall;
    @SerializedName("title")
    private String title;
    @SerializedName("balance")
    private BigDecimal balance;
    @SerializedName("currency")
    private String currency;
    @SerializedName("isSalary")
    private boolean isSalary;
}
