import socket
import threading
from datetime import datetime

clients = []
client_times = []

def handle_client(conn, addr):
    print(f"Connected by {addr}")
    try:
        data = conn.recv(1024).decode()
        client_time = float(data)
        client_times.append((conn, addr, client_time))
    except Exception as e:
        print(f"Error handling client {addr}: {e}")
    finally:
        pass  # Keep the connection open for reply

def seconds_to_time(ts):
    return datetime.fromtimestamp(ts).strftime('%H:%M:%S')

def berkeley_algorithm(server_time, client_data):
    all_times = [server_time] + [c[2] for c in client_data]
    avg_time = sum(all_times) / len(all_times)

    print(f"\nServer Time: {seconds_to_time(server_time)}")
    print("\nClient Times:")
    for i, (conn, addr, time_val) in enumerate(client_data):
        print(f" Client {i+1} [{addr}]: {seconds_to_time(time_val)}")

    print(f"\nAverage Time for Sync: {seconds_to_time(avg_time)}")

    adjustments = [avg_time - t[2] for t in client_data]
    for i, (conn, addr, time_val) in enumerate(client_data):
        adj = adjustments[i]
        message = f"{adj}|{server_time}"
        try:
            conn.send(message.encode())
        except Exception as e:
            print(f"Error sending adjustment to {addr}: {e}")
        direction = "ahead" if adj < 0 else "behind"
        print(f"Sent adjustment of {adj:.2f} seconds ({direction}) to {addr}")
        conn.close()

def start_server():
    server_time_now = datetime.now()
    print(f"Server started, time({server_time_now.strftime('%H:%M:%S')})")
    print("Waiting for clients...")

    server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    server.bind(('localhost', 9999))
    server.listen(5) 

    try:
        while len(clients) < 3:
            conn, addr = server.accept()
            thread = threading.Thread(target=handle_client, args=(conn, addr))
            clients.append(thread)
            thread.start()

        for thread in clients:
            thread.join()

        server_time = datetime.now().timestamp()
        berkeley_algorithm(server_time, client_times)
    except KeyboardInterrupt:
        print("\nServer shutting down...")
    finally:
        server.close()

start_server()