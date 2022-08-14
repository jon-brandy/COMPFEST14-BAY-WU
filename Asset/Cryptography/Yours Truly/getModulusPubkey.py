import os
from Crypto.PublicKey import RSA

os.system('clear')
pubkey = RSA.importKey(open('pubkey.pem', 'r').read())
print(pubkey.n, pubkey.e)
