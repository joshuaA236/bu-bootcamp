#include <stdio.h>


void swap(int *a, int *b) {
    int temp = *a;

    *a = *b;
    *b = temp;
}

void broken_swap(int a, int b) {
    int temp = a;
    
    a = b;
    b = temp;
}

int main() {
    int x = 10;
    int y = 20;

    int a = 10;
    int b = 2;

    printf("Before swap: x = %d, y = %d\n", x, y);
    swap(&x, &y);
    printf("After swap: x = %d, y = %d\n", x, y);

    printf("Before broken swap: a = %d, b = %d\n", a, b);
    broken_swap(x, y);
    printf("After broken swap: a = %d, b = %d\n", a, b);

    return 0;
}