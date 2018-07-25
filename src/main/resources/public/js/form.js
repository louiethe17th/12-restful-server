const HOMEPAGE = "http://localhost:8080/vapes";
const form = document.getElementById("edit-form");
const deleteButton = document.getElementById("delete-vape");

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
    const brand = inputs[0].value;
    const model = inputs[0].value;
    const wattage = inputs[1].value;
    const vape = {brand, model, wattage};
    const body = JSON.stringify(vape);

    fetch(ev.target.action, {
        method: ev.target.getAttribute("method"),
        body: body
    }).then(() => {
        window.location = HOMEPAGE;
    });

})
