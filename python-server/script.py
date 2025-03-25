import socket
import threading
from time import sleep

HOST = '127.0.0.1'  # localhost
PORT = 65432        # arbitrary non-privileged port

count = 0

#def simulate_sensors(conn):




with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
    s.bind((HOST, PORT))
    s.listen()
    conn, addr = s.accept()
    with conn:
        print(f"Connected by {addr}")
        while True:
            data = conn.recv(1024)
            if not data:
                break
            conn.sendall(data)





