#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef int * Array;

void print_arr(Array arr, int size)
{
    for (int i = 0; i < size; i++) {
	printf("%i ", arr[i]);
    }
    printf("\n");
}

void merge(Array arr, Array left, Array right, int endL, int endR)
{
    int i = 0, j = 0, k = 0;
    while (i < endL && j < endR) {
	if (left[i] <= right[j]) {
	    arr[k++] = left[i++];
	} else {
	    arr[k++] = right[j++];
	}
    }

    while (i < endL) {
	arr[k++] = left[i++];
    }
    while (j < endR) {
	arr[k++] = right[j++];
    }
}

void merge_sort(Array arr, int end)
{
    if (end < 2) {
	return;
    }

    int middle = end / 2;
    Array left = malloc(sizeof(int) * middle);
    Array right = malloc(sizeof(int) * (end - middle));

    memcpy(left, arr, sizeof(int) * middle);
    memcpy(right, arr + middle, sizeof(int) * (end - middle));

    merge_sort(left, middle);
    merge_sort(right, end - middle);
    merge(arr, left, right, middle, end - middle);

    free(left);
    free(right);
}

int main(void)
{
    int arr[] = {5, 4, 3, 2, 1};
    int size = sizeof(arr) / sizeof(int);
    print_arr(arr, size);
    merge_sort(arr, size);
    print_arr(arr, size);
    return 0;
}
