package _3singleton.type7;

public class SingletonTest07 {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		new Thread(new Runnable() {
			@Override
			public void run() {
				Singleton instance = Singleton.getInstance();
				System.out.println("instance.hashCode=" + instance.hashCode());
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				Singleton instance2 = Singleton.getInstance();
				System.out.println("instance2.hashCode=" + instance2.hashCode());
			}
		}).start();

		Class c = Singleton.class;
		Singleton s = (Singleton) c.newInstance();
		System.out.println(s);


		System.out.println("使用静态内部类完成单例模式");

	}

}

// 静态内部类完成， 推荐使用
class Singleton {
//	private static volatile Singleton instance;

	//构造器私有化
	private Singleton() {}

	//写一个静态内部类,该类中有一个静态属性 Singleton
	private static class SingletonInstance {
		private static final Singleton INSTANCE = new Singleton();
	}

	//提供一个静态的公有方法，直接返回SingletonInstance.INSTANCE

	//public static synchronized Singleton getInstance() {
	public static Singleton getInstance() {
		return SingletonInstance.INSTANCE;
	}
}