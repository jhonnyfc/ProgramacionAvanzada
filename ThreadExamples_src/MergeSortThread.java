
//package p8_paralelizacion;

import java.util.concurrent.RecursiveTask;

/**
 *
 * @author alumno
 */
public class MergeSortThread extends RecursiveTask<Integer>{
     
	public static void main(String[] args) {

		final int[] data = new int[10];
		final Random random = new Random();
		for (int i = 0; i < data.lenght ; i++) {
			data[i] = random.nextInt(100);
		}

		final Mergersort m = new Mergersort()
		
	}


	public class Mergesort extends RecursiveTaskm {



		protected void compute() {
	        if (size() < SEQUENTIAL_THRESHOLD) {
	            System.arraycopy(numbers, startPos, result, 0, size());
	            Arrays.sort(result, 0, size());
	        } else {
	            int midpoint = size() / 2;
	            MergeSort left = new MergeSort(numbers, startPos, startPos+midpoint);
	            MergeSort right = new MergeSort(numbers, startPos+midpoint, endPos);
	            coInvoke(left, right);
	            merge(left, right);
	        }
	    }
	}



	private class OrdenarMezclaTask extends RecursiveAction {
		private static final long serialVersion UID = -749935388568367268L;
		private final Integer[] a;
		private final Integer[] auxiliar;
		private final int inf;
		private final int sup;

		public OrdenarMezclaTask(Integer[] a, Integer[] auxiliar, int inf, int sup) {
			this.a = a;
			this.auxiliar = auxiliar;
			this.inf = inf;
			this.sup = sup;
		}

		@Override
		protected void compute() {
			if (inf < sup) {
				int medio = inf + (sup - inf) / 2;
				OrdenarMezclaTask izda = new OrdenarMezclaTask(a, auxiliar, inf, medio);
				OrdenarMezclaTask izda = new OrdenarMezclaTask(a, auxiliar, medio + 1, sup);
				invokeAll(izda, dcha);
				mezcla(this.a, this.auxiliar, this.inf, medio, this.sup);
			} else {
				return;
			}
		}

		private void mezcla(Integer[] a, Integer[] auxiliar, int inf, int medio, int sup){
	        int i=0, 
	        int leftPos=0, rightPos=0;
	        int leftSize = left.size(), rightSize = right.size();
	       	int[] result;

	        while (leftPos < leftSize && rightPos < rightSize)
	            result[i++] = (left.result[leftPos] <= right.result[rightPos])
	                    ? left.result[leftPos++]
	                    : right.result[rightPos++];
	        while (leftPos < leftSize)
	            result[i++] = left.result[leftPos++];
	        while (rightPos < rightSize)
	            result[i++] = right.result[rightPos++];
    }
		}




	}
    
    
}
