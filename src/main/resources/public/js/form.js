//COPIED DIRECTLY FROM THE DEMO

const HOMEPAGE = "http://localhost:8080/fabrics";
const form = document.getElementById("edit-form");
const deleteButton = document.getElementById("deleteFabric");

deleteButton.addEventListener("click", (ev) => {
    fetch(form.action, {
    method: "DELETE"
    }).then(() => {
    window.location = HOMEPAGE;
    });
    });

form.addEventListener("submit", (ev) => {
    ev.preventDefault();
console.log(ev.target.method, ev.target.action);

const inputs = ev.target.getElementsByTagName("input");
const name = inputs[0].value;
const category = inputs[1].value;
const base = inputs[2].value;
const bestStore = inputs[3].value;
const isCustom = inputs[4].value;
const fabric = {name, category, base, bestStore, isCustom};
const body = JSON.stringify(fabric);

fetch(ev.target.action, {
    method: ev.target.getAttribute("method"),
    body: body
}).then(() => {
    window.location = HOMEPAGE;
});
})