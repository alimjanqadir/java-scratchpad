public final class BinarySearch {
	 public static int binarySearch(int[] array, int lowerBound, int upperBound, int target) {
		// Termination condition
		if(upperBound < lowerBound) return -1;
		
		int mid = lowerBound + (upperBound - lowerBound) / 2;
		if(target < array[mid])         return binarySearch(array, lowerBound, mid - 1, target);
		else if(target > array[mid])    return binarySearch(array, mid + 1, upperBound, target);
		else            		return  mid;
	 }

 	public static void main(String[] args) {
 		System.out.println(binarySearch(new int[]{1,2,3,4,5,6,7,8,9}, 0, 8, 5));
 	}
 	
}
