import pyautogui
import time
inputs = [...]
f = open("idx.txt")
idx = int(f.read())
f.close()
print(idx)
pyautogui.moveTo(192, 370) # tombol reset
pyautogui.click()

string = inputs[idx]
for i in string:
    if i == '0':
        pyautogui.moveTo(100, 231) # tombol 0
        pyautogui.click()
    elif i == '1':
        pyautogui.moveTo(250, 231) # tombol 1
        pyautogui.click()

f = open("idx.txt", "w")
f.write(str(idx + 1))
f.close()
