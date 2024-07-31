const btn = document.querySelector('.talk');
const content = document.querySelector('.content');

function speak(text) {
    const text_speak = new SpeechSynthesisUtterance(text);
    text_speak.rate = 1;
    text_speak.pitch = 1;
    text_speak.volume = 1;
    window.speechSynthesis.speak(text_speak);
}

window.addEventListener('load', () => {
    speak("Inicializando JARVIS");
    wishMe();
});

function wishMe() {
    const day = new Date();
    const hour = day.getHours();

    if (hour >= 0 && hour < 12) {
        speak("Bom dia, senhor.");
    } else if (hour >= 12 && hour < 17) {
        speak("Boa tarde, senhor.");
    } else {
        speak("Boa noite, senhor.");
    }
}

const SpeechRecognition = window.SpeechRecognition || window.webkitSpeechRecognition;
const recognition = new SpeechRecognition();
recognition.lang = 'pt-BR'; // Define a linguagem para português do Brasil

recognition.onresult = (event) => {
    const transcript = event.results[event.resultIndex][0].transcript;
    content.textContent = transcript;
    takeCommand(transcript.toLowerCase());
};

recognition.onerror = (event) => {
    console.error("Erro no reconhecimento de voz: ", event.error);
    speak("Desculpe, não consegui entender. Pode repetir?");
};

btn.addEventListener('click', () => {
    content.textContent = "Estou ouvindo...";
    recognition.start();
});

function takeCommand(message) {
    if (message.includes('oi') || message.includes('olá')) {
        speak("Olá, senhor. Como posso ajudá-lo?");
    } else if (message.includes("abrir google")) {
        window.open("https://google.com", "_blank");
        speak("Abrindo Google.");
    } else if (message.includes("abrir youtube")) {
        window.open("https://youtube.com", "_blank");
        speak("Abrindo YouTube.");
    } else if (message.includes("abrir facebook")) {
        window.open("https://facebook.com", "_blank");
        speak("Abrindo Facebook.");
    } else if (message.includes('o que é') || message.includes('quem é') || message.includes('o que são')) {
        window.open(`https://www.google.com/search?q=${message.replace(/ /g, "+")}`, "_blank");
        speak("Buscando informações sobre " + message + " na internet.");
    } else if (message.includes('wikipedia')) {
        window.open(`https://pt.wikipedia.org/wiki/${message.replace("wikipedia", "").trim()}`, "_blank");
        speak("Aqui está o que encontrei na Wikipedia sobre " + message);
    } else if (message.includes('que horas são')) {
        const time = new Date().toLocaleTimeString('pt-BR');
        speak("A hora atual é " + time);
    } else if (message.includes('que dia é hoje')) {
        const date = new Date().toLocaleDateString('pt-BR', { weekday: 'long', day: 'numeric', month: 'long', year: 'numeric' });
        speak("Hoje é " + date);
    } else if (message.includes('calculadora')) {
        try {
            window.open('Calculator:///');
            speak("Abrindo calculadora.");
        } catch (e) {
            speak("Desculpe, não consegui abrir a calculadora.");
        }
    } else {
        window.open(`https://www.google.com/search?q=${message.replace(/ /g, "+")}`, "_blank");
        speak("Aqui está o que encontrei para " + message + " no Google.");
    }
}
