import { useState } from 'react'
import './App.css'
import '@chatscope/chat-ui-kit-styles/dist/default/styles.min.css'
import { MainContainer, ChatContainer, MessageList, Message, MessageInput, TypingIndicator } from '@chatscope/chat-ui-kit-react'
import { API_KEY } from './config'; // Import the API key from config.js

//const API_KEY = '';
const systemMessage = {
  "role": "system",
  "content": "Give recommendations of where to go to users based on their interests and crowd levels at different places. You should also be able to make schedules for users if the users request schedules."
}


function App() {
  const [messages, setMessages] = useState([
    {
      message: "Hello, I am PopuLert's AI chat advisor! I am here to give recommendations on different places to go to based on your interests and crowd levels at those places. Additionally, I can create an efficient schedule for you!",
      sentTime: "just now",
      sender: "ChatGPT"
    }
  ])




  const [isTyping, setIsTyping] = useState(false)




  const handleSend = async (message) => {
   
    const newMessage = {
      message,
      direction: 'outgoing',
      sender: "user"
    }




    const newMessages = [...messages, newMessage];
     
    setMessages(newMessages);


    //Set typing indicator("ConvoAI is typing")
    setIsTyping(true);


    await processMessageToChatGPT(newMessages);
  }


  async function processMessageToChatGPT(chatMessages) {
    let apiMessages = chatMessages.map((messageObject) => {
      let role = "";
      if (messageObject.sender === "ChatGPT") {
        role = "assistant";
      } else {
        role = "user";
      }
      return { role: role, content: messageObject.message}
    });


    const apiRequestBody = {
      "model": "gpt-3.5-turbo",
      "messages": [
        systemMessage,  // The system message DEFINES the logic of our chatGPT
        ...apiMessages // The messages from our chat with ChatGPT
      ]
    }


    await fetch("https://api.openai.com/v1/chat/completions",
    {
      method: "POST",
      headers: {
        "Authorization": "Bearer " + API_KEY,
        "Content-Type": "application/json"
      },
      body: JSON.stringify(apiRequestBody)
    }).then((data) => {
      return data.json();
    }).then((data) => {
      console.log(data);
      setMessages([...chatMessages, {
        message: data.choices[0].message.content,
        sender: "ChatGPT"
      }]);
      setIsTyping(false);
    });
  }
 
  return (
    <div className="App">
      <div style={{position: "relative", height: "800px", width: "900px"}}>
      <MainContainer>
          <ChatContainer>      
            <MessageList
              scrollBehavior="smooth"
              typingIndicator={isTyping ? <TypingIndicator content="ConvoAI is typing" /> : null}
            >
              {messages.map((message, i) => {
                console.log(message)
                return <Message key={i} model={message} />
              })}
            </MessageList>
            <MessageInput placeholder="Type message here" onSend={handleSend} />        
          </ChatContainer>
        </MainContainer>
      </div>
    </div>


  )
}


export default App


