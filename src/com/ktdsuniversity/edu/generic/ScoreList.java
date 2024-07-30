package com.ktdsuniversity.edu.generic;

import java.util.function.Function;

/**
 * 
 * @param <T> : 점수의 타입
 */
public class ScoreList<T> {

	/**
	 * 점수 배열
	 */
	private Object[] scoreArray;
	
	/**
	 * 점수 배열에 등록된 아이템의 개수
	 * 점수를 등록할 때마다 하나씩 증가한다
	 */
	private int size;
	
	public ScoreList() {
		// this.scoreArray = new T[2]; // 생성자가 호출될 때 무슨 타입인지 모르기 때문에 T를 쓸 수 없다. 대신 Object 사용해서 배열로 instance 생성될 수 있게 함
		this.scoreArray = new Object[2];
	}
	
	/**
	 * scoreArray 배열에 아이템을 추가한다
	 * 아이템이 추가될 때마다 size 값은 하나씩 증가해야한다
	 * 
	 * 만약, size의 값이 배열의 길이보다 크거나 같을 경우에 
	 * scoreArray 배열의 길이는 두 개씩 늘어나도록 한다
	 * 
	 * @param score 배열에 추가할 아이템
	 */
	public void add(T score) {
		/*
		 * 배열의 길이가 2이고
		 * size의 값이 2였다면?
		 * ArrayIndexOutOfBoundsException 던져짐!
		 */
		if (this.size >= this.scoreArray.length) {
			// 배열의 길이를 늘려준다
			Object[] tempScoreArray = new Object[this.scoreArray.length + 2];
			
			// 배열을 복사한다
			// this.scoreArray의 0번 인덱스부터 this.scoreArray.length까지
			// tempScoreArray의 0번 인덱스를 시작으로 복사를 해준다
			System.arraycopy(this.scoreArray, 0, tempScoreArray, 0, this.scoreArray.length);
			
			// 메모리를 교체한다
			this.scoreArray = tempScoreArray;
		}
		this.scoreArray[this.size++] = score;
	}
	
	public T get(int index) {
		if (index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsException(index);
		}
		
		// this.scoreArray[index]의 결과는 Objcect이므로 T 타입으로 형 변환 해야한다.
		return (T) this.scoreArray[index];
	}
	
//	public T getSum() {
//		for (T sum: (T[]) this.scoreArray) {
//			sum += score;
//		}
//		return sum;
//	}
	
	// 컴파일 코드: 컴파일 시점에 돌아가는 코드
	// 런타임: 코드가 실행되는 시점
	// 이건 런타임 때 알 수 있다
	
	public void forEach(Function<T, Integer> function) {
		
		int sum = 0;
		for (Object object : this.scoreArray) {
			sum += function.apply((T) object);
		}
		System.out.println(sum);
	}
	
	/**
	 * scoreArray에 등록된 아이템의 개수를 반환
	 * @return
	 */
	public int getSize() {
		return this.size;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("ScoreList[");
		for (Object score: this.scoreArray) {
			sb.append(score + ", ");
		}
		sb.append("]");
		return sb.toString();
	}
}
