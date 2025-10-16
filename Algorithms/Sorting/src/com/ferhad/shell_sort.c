#include <stdio.h>

void print_arr(int *arr, int len)
{
	for (int i = 0; i < len; i++) {
		printf("%d\t", arr[i]);
	}
	printf("\n");
}

/*
 * Shell sort is an optimized variance of insertion sort
 * It gives better performance when elements are not in almost sorted order
 * (where insertion sort gives O(n^2))
 */
void shell_sort(int *arr, int len)
{
	for (int gap = len / 2; gap > 0; gap /= 2) {
		for (int i = gap; i < len; i++) {
			for (int j = i - gap; j >= 0; j--) {
				if (arr[j] > arr[j + gap]) {
					int tmp = arr[j];
					arr[j] = arr[j + gap];
					arr[j + gap] = tmp;
				}
			}
		}
	}
}

int main(void)
{
	int arr[] = {5, 4, 3, 2, 1};
	int len = sizeof(arr) / sizeof(arr[0]);

	print_arr(arr, len);
	shell_sort(arr, len);
	print_arr(arr, len);

	return 0;
}
