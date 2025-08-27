package com.mc.coffeemanager.domain.discount.condition;

import com.mc.coffeemanager.domain.order.Order;

public class OrderPriceCondition implements DiscountCondition {

  private final int min;
  private final int max;

  /***
   *
   * @param min : 할인을 위한
   * @param max
   */
  public OrderPriceCondition(int min, int max) {
    if (min < 0 || max < 0) {
      throw new IllegalArgumentException("min, max는 0보다 작을 수 없습니다.");
    }

    if (max <= min) {
      throw new IllegalArgumentException("max는 min보다 커야합니다.");
    }

    this.min = min;
    this.max = max;
  }

  @Override
  public boolean isSatisfied(Order order) {
    return order.getOrderPrice() >= min && order.getOrderPrice() <= max;
  }
}
