#include <stdio.h>
#include <stdbool.h>
#include <assert.h>

#define BYTE_IN(x, n) (((x) >> (n)) & 1)

#define PRINTF_BYTE(desc, x) 		\
	printf("%s%d%d%d%d%d%d%d%d\n", 	\
			(desc), 			 	\
			BYTE_IN((x), 7), 		\
			BYTE_IN((x), 6), 		\
			BYTE_IN((x), 5), 		\
			BYTE_IN((x), 4), 		\
			BYTE_IN((x), 3), 		\
			BYTE_IN((x), 2), 		\
			BYTE_IN((x), 1), 		\
			BYTE_IN((x), 0)) 		\

int getbit(int n, int i);
void setbit(int *n, int i);
void togglebit(int *n, int i);
void cleanbit(int *n, int i);
bool is_power_of_two(int n);
int getbits(int x, int p, int n);
void setbits(int *x, int p, int n);
void invert(int *x, int p, int n);
int countbit(int x);

int main(void) {
	int a, b;

	a = 0b00010010;
	b = 0b00001111;
	assert(getbit(a, 4) == 1);
	assert(getbit(b, 4) == 0);

	setbit(&a, 4);
	setbit(&b, 4);
	assert(getbit(a, 4) == 1);
	assert(getbit(b, 4) == 1);
	assert(a == 0b00010010);
	assert(b == 0b00011111);

	togglebit(&a, 4);
	togglebit(&b, 7);
	assert(a == 0b00000010);
	assert(b == 0b10011111);

	cleanbit(&a, 1);
	cleanbit(&b, 3);
	assert(a == 0b00000000);
	assert(b == 0b10010111);

	assert(is_power_of_two(4));
	assert(is_power_of_two(16));
	assert(is_power_of_two(128));
	assert(!is_power_of_two(127));

	int a_part = getbits(a, 3, 4);
	int b_part = getbits(b, 3, 4);
	assert(a_part == 0b0000);
	assert(b_part == 0b0111);

	setbits(&a, 3, 4);
	setbits(&b, 3, 4);
	assert(a == 0b1111);
	assert(b == 0b10011111);

	invert(&a, 3, 4);
	invert(&b, 3, 4);
	assert(a == 0b00000000);
	assert(b == 0b10010000);

	int c = countbit(0b11001100);
	assert(c == 4);

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
bool is_power_of_two(int n)
{
    return (n >= 0) && (n & (n - 1)) == 0;
}

/*
 * Reverses 32 bit number's bit representation
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

/*
 * Get n bits from position p
 */
int getbits(int x, int p, int n)
{
	return (x >> (p + 1 - n)) & ~(~0 << n);
}

/*
 * Set n bits of x to 1 from position p
 */
void setbits(int *x, int p, int n)
{
	*x |= ((1 << n) - 1) << (p + 1 - n);
}

/*
 * Inverts(0->1,1->0) n bits of x from position p
 */
void invert(int *x, int p, int n)
{
	*x ^= ((1 << n) - 1) << (p + 1 - n);
}

/*
 * Counts set bits in number x
 */
int countbit(int x)
{
	int c = 0;

	for (; x != 0; x >>= 1) {
		c += (x & 1);
	}

	return c;
}
