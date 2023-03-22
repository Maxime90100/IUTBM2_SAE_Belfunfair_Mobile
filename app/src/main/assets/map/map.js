const svg = document.getElementById('mapSVG');
const satelite = svg.querySelector('#satelite');

const PATHS = svg.querySelectorAll('path');
const paths = Array.from(PATHS).filter(path => path.id !== 'plan');

const BUTTONS = document.querySelectorAll('button')
const buttons = Array.from(BUTTONS).filter(btn => btn.id.includes('btn'))

changeMap()
setButtonsListeners()
setPathsListeners()

function changeMap(){
    let btn = document.getElementById("changeMap")
    let html
    if(btn.classList.contains("satellite")){
        html = "<i class=\"fa-solid fa-map\"></i> Carte"
        satelite.style.opacity = "0"
        btn.classList.remove("satellite")
    }else{
        html = "<i class=\"fa-solid fa-globe\"></i> Satellite"
        satelite.style.opacity = "100"
        btn.classList.add("satellite")
    }
    btn.innerHTML = html
}

function setPathsListeners(){
    paths.forEach(path => {
        path.addEventListener("click", function() {
            paths.forEach(p => p.style.fill = "gray");
            path.style.fill = "darkorange";
            Android.showToast(path.id);
            Android.getAttractions(path.id);
        });
    });
}

function setButtonsListeners(){
    buttons.forEach(btn => {
        let type = btn.id.replace('btn_','')
        console.log(type)
        btn.addEventListener("click", function () {
            if(btn.classList.contains("check")){
                btn.classList.remove("check")
                showPaths(type,false)
            }else{
                btn.classList.add("check")
                showPaths(type,true)
            }
        });
    });
}

function showPaths(type,show){
    let selectedPaths = []
    if(type !== "other"){
        selectedPaths = paths.filter(path => path.id.includes(type))
    }
    else{
        selectedPaths = paths.filter(path => {
            return path.id.includes("secours") || path.id.includes("security") || path.id.includes("billetterie");
        })
    }
    selectedPaths.forEach(path => {
        if(show){
            path.style.opacity = "100"
            path.style.pointerEvents = "auto"
        }
        else{
            path.style.opacity = "0"
            path.style.pointerEvents = "none"
        }
    });
}