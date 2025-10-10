#include <stdio.h>

int getbit(int n, int i);
void setbit(int *n, int i);
void togglebit(int *n, int i);
void cleanbit(int *n, int i);
int is_power_of_two(int n);

int main(void) {
    int n = 0b000000011;
    printf("Res: %d\n", is_power_of_two(n));
    return 0;
}

/*
 * Get k(th) bit
 */
int getbit(int n, int i)
{
    return (n >> i) & 1;
}

/*
 * Set k(th) bit
 */
void setbit(int *n, int i)
{
    *n |= (1 << i);
}

/*
 * Clean k(th) bit
 */
void cleanbit(int *n, int i)
{
    *n &= ~(1 << i);
}

/*
 * Toggle k(th) bit
 */
void togglebit(int *n, int i)
{
    *n ^= (1 << i);
}

/*
 * Checks if number is power of two
 */
int is_power_of_two(int n)
{
    return (n >= 0) && (n & (n - 1)) == 0;
}

/*
 * Reverses number's bit representation
 */
int reverseBits(int n) {
    int k = 32;
    int res = 0;

    while (n > 0) {
        int last = n & 1;
        res |= (last << --k);
        n >>= 1;
    }

    return res;
}

/*
 * Finds missing number in nums (len: n) in interval of 0..n
 */
int missingNumber(int* nums, int len) {
    int res = 0;
    for (int i = 1; i <= len; i++) {
        res ^= i;
    }

    for (int i = 0; i < len; i++) {
        res ^= nums[i];
    }

    return res;
}
