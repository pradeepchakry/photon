use jni::JNIEnv;
use jni::objects::{JClass, JString};
use jni::sys::jstring;
use std::io::prelude::*;
use std::net::TcpListener;
use std::net::TcpStream;
use std::fs;


#[no_mangle]
pub extern "system" fn Java_com_b3soft_photon_SampleService_hello(env: JNIEnv,
// This is the class that owns our static method. It's not going to be used,
// but still must be present to match the expected signature of a static
// native method.
                                             class: JClass,
                                             input: JString)
                                             -> jstring {
    // First, we have to get the string out of Java. Check out the `strings`
    // module for more info on how this works.
    let input: String =
        env.get_string(input).expect("Couldn't get java string!").into();

    // Then we have to create a new Java string to return. Again, more info
    // in the `strings` module.
    let output = env.new_string(format!("Hello, {}!", input))
        .expect("Couldn't create java string!");

    // Finally, extract the raw pointer to return.
    output.into_inner()
}

#[no_mangle]
pub  extern "system" fn Java_com_b3soft_photon_ServerInstance_startServer(
    env: JNIEnv,
    class: JClass,
    input: JString) -> jstring {
        let mut port: String =
            env.get_string(input).expect("Couldn't get java string!").into();
         
        let mut local_ip: String = "127.0.0.1:".to_owned();
        local_ip.push_str(&port);

        println!("Server is about to bind at {}", local_ip);

        let listener = TcpListener::bind(local_ip)
            .unwrap();

        println!("Server started!");

        let mut connection_estb: bool = false;

        for stream in listener.incoming() {
            let stream = stream.unwrap();
            connection_estb = true;

            handle_connection(stream);
        }

                                           
        let output = env.new_string(format!("Connection established: {}", connection_estb))
                        .expect("Couldn't create java string!");
        output.into_inner()
}

fn handle_connection(mut stream: TcpStream) {
    let mut buffer = [0; 1024];
    stream.read(&mut buffer).unwrap();

    let get = b"GET / HTTP/1.1\r\n";

    // let mut contents = "{\"success\": \"true\"}";

    let (status_line, contents) = if buffer.starts_with(get) {
        // ("HTTP/1.1 200 OK", "greentea.html");
        println!("GET - Resource ACCESSED");
        ("HTTP/1.1 200 OK", "{\"value\": \"Success\"}")
    } else {
        // ("HTTP/1.1 404 NOT FOUND", "404.html");
        println!("RESOURCE NOT FOUND");
        ("HTTP/1.1 404 NOT FOUND", "{\"value\": \"Resource Not Found\"}")
    };

    println!("status line {}", status_line);
    println!("contents lenght {}", contents.len());
    println!("contents  {}", contents);
    
    let response = format!(
        "{}r\nContent-Type: application/json\r\nContent-Length: {}\r\n\r\n{}",
        status_line,
        contents.len(),
        contents
    );

    stream.write(response.as_bytes()).unwrap();
    stream.flush().unwrap();
}