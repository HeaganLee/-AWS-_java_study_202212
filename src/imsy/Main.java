package imsy;

import imsy.Order.Builder;

class Order {
	private int orderId;
	private String productName;
	private String consumerName;
	private int price;
	private int stock;
	
	private Order(Builder builder) {
		this.orderId = builder.orderId;
		this.productName = builder.consumerName;
		this.consumerName = builder.consumerName;
		this.price = builder.price;
		this.stock = builder.stock;
	}
	
	public static Builder builder() {
		return new Builder();
	}
	
	// static으로 잡아 주면 Order를 생성하지 않더라도 사용이 가능하다
	// 참조를 할 수 있다.
	// 하나로 합칠 때는 static을 써주어야 한다.
	public static class Builder{
		private int orderId;
		private String productName;
		private String consumerName;
		private int price;
		private int stock;
		
		private Builder(){}
		
		public Builder orderId(int orderId){
			this.orderId = orderId;
			return this;
		}
		
		public Builder productName(String productName) {
			this.productName = productName;
			return this;
		}
		
		public Builder consumerName(String consumerName) {
			this.consumerName = consumerName;
			return this;
		}
		
		public Builder price(int price) {
			this.price = price;
			return this;
		}
		
		public Builder stock(int stock) {
			this.stock = stock;
			return this;
		}
		
		public Order build() {
			return new Order(this);
		}
		
	}
		public void showOrderInfo(){
			System.out.println("주문번호: " + orderId + "\n상품명: " + productName + "\n구매자: " + consumerName + "\n가격: " + price + "\n수량: " + stock );
		}
	
}

public class Main {

	public static void main(String[] args) {
		Order order = null;
		order = order.builder()
				.orderId(100)
				.productName("Samsung GalaxyBook2 pro")
				.consumerName("홍길동")
				.price(1450000)
				.stock(2)
				.build();
		order.showOrderInfo();
	}
}
