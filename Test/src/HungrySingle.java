/**
 * 恶汉模式
 * <p>Title: HungrySingle</p>
 * <p>Description: </p>
 * <p>Company: </p> 
 * @author tangp
 * @date 2019年12月16日下午7:11:02
 */
public class HungrySingle {
	// 初始化变量的时候最好加上 final 关键字，这样比较严谨。
	private static final HungrySingle hungrySingle = new HungrySingle();
	
	static {  
        System.out.println("---->类级的内部类被加载");  
    }  
	// 私有构造
    private HungrySingle(){  
        System.out.println("---->类级的内部类构造函数被调用");  
    } 
	
	// 公布静态方法
	public static HungrySingle getInstance(){
		return hungrySingle;
	}
	
}
