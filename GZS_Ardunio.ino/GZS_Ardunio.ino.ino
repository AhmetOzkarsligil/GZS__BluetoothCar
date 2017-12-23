// PİLLERİN OLDUĞU  TARAF İLERİ YÖNÜ
// A MOTORU sağ taraftaki motor 


const int Motor_A_Enable = 5;
const int Motor_A_Reverse = 4;
const int Motor_A_Forward = 3;

const int Motor_B_Enable = 10;
const int Motor_B_Reverse = 8;
const int Motor_B_Forward = 9;
static int hiz=80;
void setup() {
  
  Serial.begin(9600);
  
  pinMode(Motor_A_Enable, OUTPUT);
  pinMode(Motor_A_Forward, OUTPUT);
  pinMode(Motor_A_Reverse, OUTPUT);

  pinMode(Motor_B_Enable, OUTPUT);
  pinMode(Motor_B_Forward, OUTPUT);
  pinMode(Motor_B_Reverse, OUTPUT);
  
}

void loop() 
{

  if(Serial.available() > 0) // eğer veri var ise :
  {
    char data;
    data = Serial.read(); // Veriyi oku
    Serial.write(Serial.read());
    
       switch (data)
      {
        case '1': //İleri          
          analogWrite(Motor_B_Enable, hiz);
          analogWrite(Motor_A_Enable, hiz);
  
          digitalWrite(Motor_A_Reverse, LOW);
          digitalWrite(Motor_B_Reverse, LOW);
          digitalWrite(Motor_A_Forward, HIGH);
          digitalWrite(Motor_B_Forward, HIGH);
  
          break;
          
        case '2': //Geri
          
          analogWrite(Motor_B_Enable, hiz);
          analogWrite(Motor_A_Enable, hiz);
  
  
          digitalWrite(Motor_A_Forward, LOW);
          digitalWrite(Motor_B_Forward, LOW);   
          digitalWrite(Motor_A_Reverse, HIGH);
          digitalWrite(Motor_B_Reverse, HIGH);
     
          break;
          
        case '3': //İleri Sol
          //nos();
          analogWrite(Motor_A_Enable, hiz);
          analogWrite(Motor_B_Enable, 0);
          
          digitalWrite(Motor_A_Reverse, LOW);
          digitalWrite(Motor_A_Forward, HIGH);
          break;
          
        case '4': //İleri Sağ
          
          analogWrite(Motor_B_Enable, hiz);
          analogWrite(Motor_A_Enable, 0);
  
          
          digitalWrite(Motor_B_Reverse, LOW);
          digitalWrite(Motor_B_Forward, HIGH);
  
          
          break;
          
        case '5': //Geri Sol
          // nos();
          analogWrite(Motor_A_Enable, hiz);
          analogWrite(Motor_B_Enable, 0);
  
          digitalWrite(Motor_A_Forward, LOW);   
          digitalWrite(Motor_A_Reverse, HIGH);
        
          break;
          
        case '6': //Geri Sağ
        
          analogWrite(Motor_B_Enable, hiz);
          analogWrite(Motor_A_Enable, 0);
  
                  
          digitalWrite(Motor_B_Reverse, HIGH);
          digitalWrite(Motor_B_Forward, LOW);     
          break;
  
        case '7': // 360 Derece Dön
         
          analogWrite(Motor_B_Enable, hiz);
          analogWrite(Motor_A_Enable, hiz);
  
          digitalWrite(Motor_A_Forward, HIGH);
           digitalWrite(Motor_A_Reverse, LOW);
           
          digitalWrite(Motor_B_Forward, LOW); 
          digitalWrite(Motor_B_Reverse, HIGH); 
          break;
    // nos butonuna basıldıktan sonra basılan herhangi bir butonun hız özelliğinin değiştirlmesi için kullanılmaktadır
        case '8': //NOS
            hiz=240;
           // delay(500);
          break;
  
        case '9': //NOS
            hiz=80;
            delay(250);
        break;
     
        default: 
          analogWrite(Motor_A_Enable, 0);
          analogWrite(Motor_B_Enable, 0); 
          // break konulmamıştır çünkü Nos butonu ile basılan bir başka butonun 250 ms boyunca istenilen haraketi yaparak 
          // case 1 geçip otomatik olarak ileri gitmesi istenmiştir
      }
    }    
  }
    


