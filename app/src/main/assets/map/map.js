const result = document.querySelector('#result');
const svg = document.getElementById('mapSVG');
const satelite = svg.querySelector('#satelite');
const PATHS = svg.querySelectorAll('path');
const paths = Array.from(PATHS).filter(path => path.id !== 'plan');

paths.forEach(path => {
    path.addEventListener("click", function() {
        paths.forEach(p => p.style.fill = "gray");
        path.style.fill = "darkorange";
        Android.showToast(path.id);
    });
});

function changeMap(){
    satelite.style.opacity = satelite.style.opacity === "0" ? "100" : "0"
}