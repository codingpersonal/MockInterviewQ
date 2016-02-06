/*There are 2 sorted arrays.
 * a1 = 1,2,3,4,5
 * a2 = 4,5,8,9
 * find a3 which is intersection of these two
 * a3 = 4,5
 * 
 * also do a version where if there are duplicates you avoid them
 * a1 = 2,2,3,4,5
 * a2 = 2,2
 * a3 = 2,2 or a3 = 2*/

public class FindIntersectionOfSortedArrays {
	public void intersection_dup_remove(int a1[], int a2[]) {
		int p1 = 0;
		int p2= 0;
		int curr = -1;
		while(p1 <= a1.length-1 && p2 <= a2.length-1) {
			if(a1[p1] == a2[p2]) {
				if(a1[p1] == curr) {
					//do nothing
				} else {
					curr = a1[p1];
					System.out.print(a1[p1]+" ");
				}
				p1++;
				p2++;
			} else if(a1[p1] > a2[p2]) {
				p2++;
			} else {
				p1++;
			}
		}
	}
	
	public void intersection_dup(int a1[], int a2[]) {
		int p1 = 0;
		int p2= 0;
		while(p1 <= a1.length-1 && p2 <= a2.length-1) {
			if(a1[p1] == a2[p2]) {
				System.out.print(a1[p1]+" ");
				p1++;
				p2++;
			} else if(a1[p1] > a2[p2]) {
				p2++;
			} else {
				p1++;
			}
		}
	}
	
	public static void main(String[] args) {
		int a1[] = {1,1,2,2,3,4,5,5};
		int a2[] = {1,1,3,5,5};
		FindIntersectionOfSortedArrays f = new FindIntersectionOfSortedArrays();
		f.intersection_dup(a1, a2);
		System.out.println("\n");
		f.intersection_dup_remove(a1, a2);
	}

}
