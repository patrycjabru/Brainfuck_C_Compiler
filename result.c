#include <stdio.h>
 
int main()
{
	char array[100] = {0};
	char *ptr=array;
	++*ptr;
	while (*ptr) {
		--*ptr;
		while (*ptr) {
			--ptr;
			--ptr;
			while (*ptr) {
				++*ptr;
				while (*ptr) {
					--*ptr;
					--*ptr;
					--*ptr;
					++ptr;
				}
				--*ptr;
				while (*ptr) {
					--ptr;
					--ptr;
					--ptr;
				}
			}
		}
		++ptr;
		++ptr;
		++ptr;
		--*ptr;
	}
	++ptr;
	--*ptr;
	putchar(*ptr);
	--*ptr;
	--*ptr;
	--*ptr;
	putchar(*ptr);
	++ptr;
	putchar(*ptr);
	putchar(*ptr);
	++ptr;
	putchar(*ptr);
	--ptr;
	--ptr;
	--ptr;
	--ptr;
	--*ptr;
	putchar(*ptr);
	--ptr;
	++*ptr;
	putchar(*ptr);
	++ptr;
	++ptr;
	++ptr;
	++ptr;
	++ptr;
	putchar(*ptr);
	++ptr;
	putchar(*ptr);
	--ptr;
	--ptr;
	putchar(*ptr);
	--ptr;
	--*ptr;
	putchar(*ptr);
	return 0;
}
