#include <stdio.h>

int getbit(int n, int i);
void setbit(int *n, int i);
void togglebit(int *n, int i);
void cleanbit(int *n, int i);

int main(void) {
    int n = 0b000000010;
    printf("%d\n", getbit(n, 1));
    cleanbit(&n, 1);
    printf("%d\n", getbit(n, 1));
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
    // 00110000
    *n |= (1 << i);
}

/*
 * Clean k(th) bit
 */
void cleanbit(int *n, int i)
{
    // 101
    // AND 011
    // 001
    *n &= ~(1 << i);
}

/*
 * Toggle k(th) bit
 */
void togglebit(int *n, int i)
{
    *n ^= (1 << i);
}
