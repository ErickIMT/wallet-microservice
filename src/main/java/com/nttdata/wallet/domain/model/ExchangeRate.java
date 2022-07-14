package com.nttdata.wallet.domain.model;

import lombok.Data;

import java.util.Date;

@Data
public class ExchangeRate {

  private float buy;
  private float sell;
  private Date registeredDate;
}
