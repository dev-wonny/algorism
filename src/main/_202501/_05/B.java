package main._202501._05;

import java.util.HashMap;
import java.util.Map;

public class B {
    public static void main(String[] args) {

        System.out.println("expect:14 , result:" + solution(
                new Pizza[] {
                    new Pizza("greek", 7, 5, 10)
                    , new Pizza("texas", 8, 9, 13)
                    , new Pizza("european", 5, 10, 13)
                }
                , new OrderItem[] {
                    new OrderItem("texas", "Medium", 1)
                    , new OrderItem("european", "Small", 2)
                }
            )
        );// 할인1) 적용

        System.out.println("expect:900 , result:" + solution(
                new Pizza[] {
                    new Pizza("margherita", 90, 80, 100)
                    , new Pizza("hawai", 80, 90, 120)
                    , new Pizza("capricciosa", 50, 70, 130)
                    , new Pizza("greek", 50, 70, 130)
                }
                , new OrderItem[] {
                    new OrderItem("greek", "Small", 5)
                    , new OrderItem("margherita", "Small", 4)
                    , new OrderItem("hawai", "Large", 1)
                    , new OrderItem("margherita", "Medium", 2)
                    , new OrderItem("capricciosa", "Small", 7)
                }
            )
        );// 할인2) 적용

        System.out.println("expect:117 , result:" + solution(
                new Pizza[] {
                    new Pizza("margherita", 7, 8, 10)
                    , new Pizza("hawai", 8, 9, 12)
                    , new Pizza("capricciosa", 5, 7, 13)
                }
                , new OrderItem[] {
                    new OrderItem("margherita", "Small", 3)
                    , new OrderItem("capricciosa", "Large", 2)
                    , new OrderItem("hawai", "Large", 3)
                    , new OrderItem("margherita", "Large", 1)
                    , new OrderItem("hawai", "Medium", 1)
                    , new OrderItem("capricciosa", "Small", 5)
                    , new OrderItem("capricciosa", "Medium", 1)
                }
            )
        );// 할인3) 적용

        System.out.println("expect:102 , result:" + solution(
                new Pizza[] {
                    new Pizza("boston", 7, 5, 10)
                    , new Pizza("hawai", 8, 9, 12)
                    , new Pizza("newyork", 8, 7, 130)
                    , new Pizza("philadelphia", 5, 10, 13)
                }
                , new OrderItem[] {
                    new OrderItem("boston", "Small", 3)
                    , new OrderItem("hawai", "Large", 3)
                    , new OrderItem("newyork", "Large", 1)
                    , new OrderItem("boston", "Large", 2)
                    , new OrderItem("philadelphia", "Large", 2)
                }
            )
        );// 할인3) 적용


        System.out.println("expect:102 , result:" + solution(
                new Pizza[] {
                    new Pizza("margherita", 7, 8, 10)
                    , new Pizza("hawai", 8, 9, 12)
                    , new Pizza("capricciosa", 5, 7, 13)
                }
                , new OrderItem[] {
                    new OrderItem("margherita", "Small", 1)
                    , new OrderItem("hawai", "Large", 1)
                }
            )
        );// 할인 적용 없음
    }

    private static class Pizza {
        public String name;
        public int price_S;
        public int price_M;
        public int price_L;

        public Pizza(String name, int price_S, int price_M, int price_L) {
            this.name = name;
            this.price_S = price_S;
            this.price_M = price_M;
            this.price_L = price_L;
        }
    }

    private static class OrderItem {
        public String name;
        public String size;
        public int quantity;

        public OrderItem(String name, String size, int quantity) {
            this.name = name;
            this.size = size;
            this.quantity = quantity;
        }
    }

    public static int solution(Pizza[] menu, OrderItem[] order) {
        // 할인1) 3개 사면 가장 싼거 무료
        // 할인2) 5개 구매시 100원
        // 할인3) 대형 피자 한판, 소형 피자 무료
        // 할인4) 대형 3개 -> 중형 3개 가격으로 변경

        // 조건 중 하나만 적용 가능, 최소비용 구하라

        Map<String, Pizza> pizzaMap = new HashMap<>();
        for (Pizza pizza : menu) {
            pizzaMap.put(pizza.name, pizza);
        }

        // 초기 비용 구하기
        int ititTotalCost = initCalculateTotalCost(order, pizzaMap);
        int tempTotalCost = 0;


        Map<String, Map<String, Integer>> orderMap = new HashMap<>();
        for (OrderItem or : order) {
            orderMap.putIfAbsent(or.name, new HashMap<>());
            Map<String, Integer> sizeMap = orderMap.get(or.name);
            sizeMap.putIfAbsent(or.size, sizeMap.getOrDefault(or.size, 0) + or.quantity);
        }

//        System.out.println("OrderMap>>" + orderMap);

        // 할인 적용
        tempTotalCost = applyDiscounts(ititTotalCost, orderMap, pizzaMap);

        return Math.min(ititTotalCost, tempTotalCost);
    }

    private static int initCalculateTotalCost(OrderItem[] orders, Map<String, Pizza> pizzaMap) {
        int totalCost = 0;

        for (OrderItem order : orders) {
            Pizza pizza = pizzaMap.get(order.name);
            if (pizza != null) {
                int price = switch (order.size) {
                    case "Small" -> pizza.price_S;
                    case "Medium" -> pizza.price_M;
                    case "Large" -> pizza.price_L;
                    default -> throw new IllegalStateException("Unexpected value: " + order.size);
                };
                totalCost += price * order.quantity;
            }
        }
        return totalCost;
    }

    private static int applyDiscounts(int totalCost, Map<String, Map<String, Integer>> orderMap, Map<String, Pizza> pizzaMap) {
        // 조건별 할인 계산
        int discount1 = calculateDiscount1(orderMap, pizzaMap);
        int discount2 = calculateDiscount2(orderMap);
        int discount3 = calculateDiscount3(orderMap, pizzaMap);
        int discount4 = calculateDiscount4(orderMap, pizzaMap);

        // 최소 비용을 반환
        return totalCost - Math.max(Math.max(discount1, discount2), Math.max(discount3, discount4));
    }

    // 할인 1: 3개 주문 시, 가장 저렴한 피자 무료
    private static int calculateDiscount1(Map<String, Map<String, Integer>> orderMap, Map<String, Pizza> pizzaMap) {
        if (getTotalQuantity(orderMap) < 3) {
            return 0;
        }

        int minPrice = Integer.MAX_VALUE;

        for (Map.Entry<String, Map<String, Integer>> orderEntry : orderMap.entrySet()) {
            String pizzaName = orderEntry.getKey();
            Map<String, Integer> sizeMap = orderEntry.getValue();
            Pizza pizza = pizzaMap.get(pizzaName);

            for (Map.Entry<String, Integer> entry : sizeMap.entrySet()) {
                String size = entry.getKey();

                int price = switch (size) {
                    case "Small" -> pizza.price_S;
                    case "Medium" -> pizza.price_M;
                    case "Large" -> pizza.price_L;
                    default -> throw new IllegalStateException("Unexpected value: " + size);
                };
                minPrice = Math.min(minPrice, price);

            }
        }

        return minPrice; // 가장 저렴한 피자 가격 반환
    }

    // 할인 2: 5개 주문 시, 100원 할인
    private static int calculateDiscount2(Map<String, Map<String, Integer>> orderMap) {
        int totalQuantity = getTotalQuantity(orderMap);
        return (totalQuantity >= 5) ? 100 : 0;
    }

    // 할인 3: 대형 피자 1판 주문 시, 소형 피자 무료
    private static int calculateDiscount3(Map<String, Map<String, Integer>> orderMap, Map<String, Pizza> pizzaMap) {
        boolean hasLarge = false;
        boolean hasSmall = false;
        int smallPizzaPrice = Integer.MAX_VALUE;

        for (Map.Entry<String, Map<String, Integer>> orderEntry : orderMap.entrySet()) {
            String pizzaName = orderEntry.getKey();
            Map<String, Integer> sizeMap = orderEntry.getValue();
            Pizza pizza = pizzaMap.get(pizzaName);

            for (Map.Entry<String, Integer> entry : sizeMap.entrySet()) {
                String size = entry.getKey();
                Integer quantity = entry.getValue();
                if (size.equals("Large") && quantity > 0) {
                    hasLarge = true;

                }
                if (size.equals("Small")) {
                    hasSmall = true;
                    smallPizzaPrice = Math.min(smallPizzaPrice, pizza.price_S);
                }
            }
        }

        if (hasLarge && hasSmall) {
            return smallPizzaPrice;
        }
        return 0;
    }

    // 할인 4: 대형 3개 주문 시, 중형 3개 가격으로 변경
    private static int calculateDiscount4(Map<String, Map<String, Integer>> orderMap, Map<String, Pizza> pizzaMap) {
        int largeTotalPrice = 0;
        int mediumTotalPrice = 0;
        boolean check = false;

        for (Map.Entry<String, Map<String, Integer>> orderEntry : orderMap.entrySet()) {
            String pizzaName = orderEntry.getKey();
            Map<String, Integer> sizeMap = orderEntry.getValue();
            Pizza pizza = pizzaMap.get(pizzaName);

            for (Map.Entry<String, Integer> entry : sizeMap.entrySet()) {
                check = false;
                String size = entry.getKey();
                Integer quantity = entry.getValue();
                if (size.equals("Large") && quantity == 3) {
                    check = true;
                    largeTotalPrice = pizza.price_L * 3;
                    mediumTotalPrice = pizza.price_L * 3;

                }
            }
        }

        return check ? largeTotalPrice - mediumTotalPrice : 0;
    }

    // 주문된 총 수량 계산
    private static int getTotalQuantity(Map<String, Map<String, Integer>> orderMap) {
        int totalQuantity = 0;
        for (Map.Entry<String, Map<String, Integer>> orderEntry : orderMap.entrySet()) {
            Map<String, Integer> sizeMap = orderEntry.getValue();
            for (Map.Entry<String, Integer> entry : sizeMap.entrySet()) {
                Integer quantity = entry.getValue();
                totalQuantity += quantity;

            }
        }
        return totalQuantity;
    }

}
