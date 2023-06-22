// 문제1) 입력받은 수 만큼 * 출력 
let input = prompt('별 입력 : ')
let output = ``;
for(let i = 1; i <= input; i++){
	output += `*`
	console.log(output)
}

// 문제2) 입력받은 수 만큼 * 출력 [  - 3줄(3배수)마다 줄바꿈 ]
output = ``;
let input2 = prompt('입력 : ')
for(let i = 1; i <= input2; i++){
	output += `*`
	if( i % 3 == 0){output += `\n`; } // \ : 제어문자(이스케이프문자) \t : 들여쓰기 \n : 줄바꿈
}
console.log(output)

// 문제3) 입력받은 줄 수 만큼 * 출력  [ ex) 5 ]
//*
//**         
//***      
//****   
//*****
let input3 = prompt('입력 :')
output = ``;
for(let i = 1; i <= input3; i++){
	for(let s = 1; s <= i; s++){
		output += `*`
	}
	output += `\n`
}
console.log(output);
// 문제4) 입력받은 줄 수 만큼 * 출력 [ ex) 5 ]
//*****
//****
//***
//**
//*
let input4 = prompt(`입력 : `)
output = ``;
for(let i = 1; i <= input4; i++){
	for(let y = i; y <= input4; y++){
		output += `*`
	}
	console.log(output)
	output = ``;
}

// 문제5) 입력받은 줄 수 만큼 * 출력  [ ex) 5 ]
//    *
//   **
//  ***
// ****
//*****
let input5 = prompt(`입력 : `)
output = ``;
let space = ``;

	for(let y = 1; y <= input5  ; y++){
		for(let s = 1; s <= input5-y; s++){
			space += ` `;
		}
		output += `*`;
		console.log(space + output)
		space = ``;
	}


// 문제6) 입력받은 줄 수 만큼 * 출력  [ ex) 5 ]
//*****
// ****
//  ***
//   **
//    *
let input6 = prompt(`입력 : `)
output = ``;
space = ``;

for(let i = 1; i <= input6; i++){
	for(let y = 0; y <= input6 - i; y++){
		output += `*`;
	}
	i > 1 ? space += ` ` : space
	console.log(space + output)
	output = ``;
}

// 문제7) 입력받은 줄 수 만큼 * 출력  [ ex) 5 ]
//    *
//   ***
//  *****
// *******
//*********

let input7 = prompt(`입력 : `)
output = ``;
space = ``;

for(let i = 1; i <= input7; i ++){
	for(let b = 1; b <= input7-i; b++){
		output += ` `;
	}
	for(let s = 1; s <= i + (i-1); s++){
		output += `*`
	}
	output += `\n`
}
console.log(output)

// 문제8) 입력받은 줄 수 만큼 * 출력  [ ex) 5 ]
//*********
// *******
//  *****
//   ***
//    *
let input8 = prompt(`입력 :`)
output = ``;

for(let i = 1; i <= input8; i++){
	for(let b = 1; b < i; b ++){
		output += ` `;
	}
	for(let s = i; s <= input8*2 -i; s++){
		output += `*`;
	}
	
	output += `\n`
}
console.log(output)

// 문제9) 입력받은 줄 수 만큼 * 출력  [ ex) 10 ]
//    *
//   ***
//  *****
// *******
//*********
//*********
// *******
//  *****
//   ***
//    *
let input9 = prompt(`입력 : `)
output = ``;
space = ``;

for(let i = 1; i <= input9; i ++){
	for(let b = 1; b <= input9-i; b++){
		output += ` `;
	}
	for(let s = 1; s <= i + (i-1); s++){
		output += `*`
	}
	output += `\n`
}

for(let i = 1; i <= input9; i++){
	for(let b = 1; b < i; b ++){
		output += ` `;
	}
	for(let s = i; s <= input9*2 -i; s++){
		output += `*`;
	}	
	output += `\n`
}
console.log(output)

// 문제10) 입력받은 줄 수 만큼 * 출력  [ ex) 5 ]
//*     *
// *   *
//  * *
//   *
//  * *
// *   *
//*     *



	

















