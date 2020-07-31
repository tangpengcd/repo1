
public class  Singleton {

//	在语句1中并不是一个原子操作，在JVM中其实是3个操作：
//	1.给instance分配空间、
//	2.调用 Singleton 的构造函数来初始化、
//	3.将instance对象指向分配的内存空间（instance指向分配的内存空间后就不为null了）；
//	　　在JVM中的及时编译存在指令重排序的优化，也就是说不能保证1,2,3执行的顺序，
//	  最终的执行顺序可能是 1-2-3 也可能是 1-3-2。
//	  如果是 1-3-2，则在 3 执行完毕、2 未执行之前，被线程二抢占了，
//	  这时 instance 已经是非 null 了（但却没有初始化），
//	  所以线程二会直接返回 instance，然后使用，然后顺理成章地报错。
	private volatile static Singleton instance;
	
	private Singleton(){
		// 防止创建
	}
	public static Singleton getInstance(){
		if(instance == null){
			synchronized (Singleton.class) {
				if(instance == null){
					instance = new Singleton();
				}
			}
		}
		return instance;
	}
}
