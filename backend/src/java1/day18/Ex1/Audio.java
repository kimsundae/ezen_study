package java1.day18.Ex1;

public class Audio implements RemoteControl {
	//필드
	private int volume;
	
	@Override
	public void turnOn() {
		System.out.println("Audio를 켭니다.");		
	}
	@Override
	public void turnOff() {
		System.out.println("Audio 끕니다.");
	}
	@Override
	public void setVolume(int volume) {
		if( volume > RemoteControl.MAX_VOLUME ) {
			//만약에 볼륨이 최대볼륨보다 크면 해당 객체는 최대 볼륨으로 대입
			this.volume = RemoteControl.MAX_VOLUME; // this: 해당메소드를 호출한 객체
		}else if(volume < RemoteControl.MAX_VOLUME) {
			// 만약에 볼륨이 최소볼륨보다 작으면 해당 객체의 소음을 최소볼륨으로 대입
			this.volume = RemoteControl.MIN_VOLUME;
		}else {
			this.volume = volume;
		}
		
	}
}
