/**
 * 
 */
 
 const formatarTel = (e) => {
    if (e.target.value.length === 0) {
      e.target.value += "(";
    } else if (e.target.value.length === 3) {
      e.target.value += ")";
      e.target.value += " ";
    } else if (e.target.value.length === 10) {
      e.target.value += "-";
    }
  };