package _9decorator;

public class Decorator extends Drink {
	private Drink drink;

	public Decorator(Drink drink) { //组合 这里就是为了把drink（被修饰）引进来！！
		this.drink = drink;
	}

	@Override
	public float cost() {
		// getPrice 自己价格
		return super.getPrice() + drink.cost();
	}

	@Override
	public String getDes() {
		// obj.getDes() 输出被装饰者的信息
		return des + " " + getPrice() + " && " + drink.getDes();
	}



}
