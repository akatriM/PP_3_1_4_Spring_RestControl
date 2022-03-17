const firstTabPill = document.querySelector('.ddpills');
const firstTab = document.querySelector('.ddtabs');

window.onload = function (){
    firstTabPill.className = 'ddpills nav-link text-start active';
    firstTab.className = 'ddtabs tab-pane fade active show';
}