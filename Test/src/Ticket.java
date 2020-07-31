public class Ticket implements Runnable {
	private int num;// 票数量
	private boolean flag = true;// 若为false则售票停止

	public Ticket(int num) {
		this.num = num;
	}

	@Override
	public void run() {
		while (flag) {
			ticket1();
		}
	}

	private void ticket() {
		if (num <= 0) {
			flag = false;
			return;
		}
		try {
			Thread.sleep(20);// 模拟延时操作
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		MySingleton2a.getInstance();
		// 输出当前窗口号以及出票序列号
//		System.out
//				.println(Thread.currentThread().getName() + "售出票序列号：" + num--);
	}

	public static void main(String[] args) {
		Ticket ticket = new Ticket(5);
		Thread window01 = new Thread(ticket, "窗口01");
		Thread window02 = new Thread(ticket, "窗口02");
		Thread window03 = new Thread(ticket, "窗口03");
		window01.start();
		window02.start();
		window03.start();
	}

	// 方式一  添加方法上
	private synchronized void ticket1() {
		if (num <= 0) {
			flag = false;
			return;
		}
		try {
			Thread.sleep(20);// 模拟延时操作
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		MySingleton2a.getInstance();
//		System.out
//				.println(Thread.currentThread().getName() + "售出票序列号：" + num--);
	}

	// 方式二 添加代码上
	private void ticket2() {
		synchronized (this) {
			if (num <= 0) {
				flag = false;
				return;
			}
			try {
				Thread.sleep(20);// 模拟延时操作
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "售出票序列号："
					+ num--);
		}
	}
}
