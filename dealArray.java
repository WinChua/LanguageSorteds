import java.util.Random;
import java.util.Scanner;

public class dealArray{
	public static void sorted(int[] a){
		int length = a.length;
		// System.out.println("length:");
		// System.out.println(length);
		for(int i = 0; i < length; i++){
			for(int j = i + 1; j < length; j++){
				if(a[i] > a[j]){
					a[i] = a[i] + a[j];
					a[j] = a[i] - a[j];
					a[i] = a[i] - a[j];
				}
			}
		}
	}
	public static void swapAS(int[] a, int i, int j){
		if(i == j){
			return;
		}
		else {
			a[i] = a[i] ^ a[j];
			a[j] = a[i] ^ a[j];
			a[i] = a[i] ^ a[j];
		}
	}
	public static void QS1(int[] a, int start, int end){
		int i = start;
		int j = end;

		while(i < j - 1){
			while(i < j  && a[i] < a[--j]) {};
			swapAS(a,i,j);
			while(i < j  && a[++i] < a[j]) {};
			swapAS(a,i,j);

		}
		if(i > start + 1){
			QS1(a,start,i);
		}
		if(i + 1 < end){
			QS1(a, i + 1, end);
		}
		return;
		
	}

	public static void show(int[] a){
		for(int i : a){
			System.out.print(i + " ");
		}
		System.out.println();
	}
	public static void main(String[] args){
		Random random = new Random();
		System.out.println("Enter the length of the array:");
		Scanner input = new Scanner(System.in);
		int length = input.nextInt();
		int[] numbers = new int[length];
		for(int i = 0; i < length; i++){
			numbers[i] = random.nextInt(100);
		}
		System.out.print("The array is :");
		show(numbers);
		// sorted(numbers);
		// show(numbers);
		System.out.print("The array is :");
		QS1(numbers, 0, numbers.length);
		show(numbers);
	}
}