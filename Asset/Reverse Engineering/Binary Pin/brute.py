from itertools import chain, product
def bruteforce(charset, maxlength):
    return (''.join(candidate)
        for candidate in chain.from_iterable(product(charset, repeat=i)
        for i in range(9, maxlength + 1)))

print(list(bruteforce('01', 9)))
