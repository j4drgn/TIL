package com.mc.coffeemanager.domain.discount.policy;

import com.mc.coffeemanager.domain.discount.condition.DiscountConditionType;
import com.mc.coffeemanager.domain.order.Order;

public class AmountDiscountPolicy extends DiscountPolicy {

  private int discountAmount;

  public AmountDiscountPolicy(int discountAmount) {
    super();
    this.discountAmount = discountAmount;
  }

  @Override
  protected int getDiscountAmount(Order order) {
    for (DiscountConditionType conditionType : DiscountConditionType.values()) {
      if (conditionType.condition().isSatisfied(order)) {
        return (int) discountAmount;
      }

    }
    
    return 0;
  }
}
