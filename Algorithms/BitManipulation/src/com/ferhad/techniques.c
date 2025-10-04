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

int is_power_of_two(int n)
{
    return (n >= 0) && (n & (n - 1)) == 0;
}

