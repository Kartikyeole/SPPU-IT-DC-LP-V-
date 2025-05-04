import socket
from datetime import datetime
import random

def seconds_to_time(ts):
    return datetime.fromtimestamp(ts).strftime('%H:%M:%S')

def start_client():
    client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    client.connect(('localhost', 9999))
    
    time_offset = random.randint(-150, 150)
    simulated_time = datetime.now().timestamp() + time_offset
    print(f"\nClient simulated time (offset {time_offset} sec): {seconds_to_time(simulated_time)}")
    
    client.send(str(simulated_time).encode())
    
    # Receive data from server
    try:
        data = client.recv(1024).decode()
        if "|" not in data:
            raise ValueError(f"Invalid format received: {data}")
        
        adjustment_str, server_time_str = data.split("|")
        adjustment = float(adjustment_str)
        server_time = float(server_time_str)
        adjusted_time = simulated_time + adjustment
        
        print(f"Server original time: {seconds_to_time(server_time)}")
        print(f"Received adjustment: {adjustment:.2f} seconds")
        print(f"Adjusted client time: {seconds_to_time(adjusted_time)}\n")
    except Exception as e:
        print(f"Error in receiving or parsing server data: {e}")
    finally:
        client.close()

start_client()