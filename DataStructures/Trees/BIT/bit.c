#include <stdio.h>
#include <stdlib.h>
#include <assert.h>

struct BIT
{
    int *bit;
    int len;
};

void update(struct BIT *b, int idx, int delta)
{
    for (; idx < b->len; idx += (idx & -idx)) {
        b->bit[idx] += delta;
    }
}

int get(struct BIT *b, int idx)
{
    int sum = 0;
    for (; idx > 0; idx -= (idx & -idx)) {
        sum += b->bit[idx];
    }
    return sum;
}

struct BIT *construct(int *arr, int len)
{
    struct BIT *b = malloc(sizeof(struct BIT));
    b->len = len + 1;
    b->bit = malloc(sizeof(int) * (b->len));
    for (int i = 0; i < b->len; i++) {
        b->bit[i] = 0;
    }

    for (int i = 0; i < len; i++) {
        update(b, i + 1, arr[i]);
    }

    return b;
}

int main(void)
{
    int arr[] = {1, 2, 3, 4, 5};
    struct BIT *b = construct(arr, 5);

    int s1 = get(b, 1);
    assert(s1 == 1);
    int s2 = get(b, 2);
    assert(s2 == 3);
    int s3 = get(b, 3);
    assert(s3 == 6);
    int s4 = get(b, 4);
    assert(s4 == 10);
    int s5 = get(b, 5);
    assert(s5 == 15);

    free(b->bit);
    free(b);
    return 0;
}
