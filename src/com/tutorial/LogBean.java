package com.tutorial;

public class LogBean {
	StringBuffer logBean  = new StringBuffer("This is a text Area");
	static int i = 0;
	public LogBean()
	{
		super();
		Thread t = new Thread(new Runnable(){
			public void run() {
				while(true)
				{
					logBean.append("\n This message is from LogBean background thread. refrashing each 5 sec"+(i++));
					System.out.println("Thread :"+i+"\n");
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}}
		);
		t.start();
	
	}
	public String getLogBean() {
		return logBean.toString();
	}
	public void setLogBean(String logBean) {
		this.logBean.append("\n"+logBean);
	}
}
