package com.poly.test05;

public class LgTv implements Tv {
	//volUp : +1
	//volDown : -1
	private int vol;
	
	public LgTv() {
		System.out.println("Lg TV가 켜졌습니다.");
	}
	
	public void tvclosed() {
		System.out.println("Lg Tv가 꺼졌습니다.");
	}

	@Override
	public int volUp() {
		vol += 1;
		return vol;
	}

	@Override
	public int volDown() {
		setVol(getVol()-1);
		return getVol();
		
	}

	public int getVol() {
		return vol;
	}

	public void setVol(int vol) {
		this.vol = vol;
	}
	
	
	
	
	
}
