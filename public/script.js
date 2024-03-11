function submit1(event)
{
    event.preventDefault();
    let hotelName=document.getElementById("hotelName").value;
    let location=document.getElementById("location").value;
    let rating=document.getElementById("rating").value;
    let pool=document.getElementById("pool").checked;
    let spa=document.getElementById("spa").checked;
    let gym=document.getElementById("gym").checked;

    let hotelList=document.getElementById("hotelList");
    let row=hotelList.insertRow(-1);
    let c0=row.insertCell(0);
    let c1=row.insertCell(1);
    let c2=row.insertCell(2);
    let c3=row.insertCell(3);
    let c4=row.insertCell(4);
    let c5=row.insertCell(5);

    c0.innerHTML=hotelName;
    c1.innerHTML=location;
    c2.innerHTML=rating;
    c3.innerHTML=pool?"yes":"no";
    c4.innerHTML=gym?"yes":"no";
    c5.innerHTML=spa?"yes":"no";
}