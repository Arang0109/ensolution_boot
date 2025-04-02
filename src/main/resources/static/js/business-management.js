// validation check java Script
'use strict';

function setupValidation(selector) {
  $(selector).each(function () {
    $(this).on('submit', function (event) {
      if (!this.checkValidity()) {
        event.preventDefault();
        event.stopPropagation();
      }
      $(this).addClass('was-validated');
    });
  });
}

function bizNumFormatter(selector) {
  const inputBizNum = $(selector);

  inputBizNum.on('input', function () {
    let value = $(this).val().replace(/[^0-9]/g, '');

    if (value.length === 0) {
      return;
    }

    if (value.length > 3 && value.length <= 5) {
      value = value.slice(0, 3) + '-' + value.slice(3);
    } else if (value.length > 5) {
      value = value.slice(0, 3) + '-' + value.slice(3, 5) + '-' + value.slice(5, 10);
    }

    $(this).val(value.slice(0, 12));
  });
}

function datepickerFormatter(selector) {
  const today = new Date();
  const formatDate = today.getFullYear() + "-" + String(today.getMonth() + 1).padStart(2, '0') + "-" + String(today.getDate()).padStart(2, '0');

  selector.datepicker({
    defaultDate: new Date(),
    dateFormat: "yy-mm-dd",
    closeText: "닫기",
    currentText: "오늘",
    prevText: '이전 달',
    nextText: '다음 달',
    monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
    monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
    dayNames: ['일', '월', '화', '수', '목', '금', '토'],
    dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
    dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
    weekHeader: "주",
    yearSuffix: '년',
  });

  selector.val(formatDate);
}

function mapView(selector, address) {
  $(selector).on("click", function () {
    const url = "https://map.naver.com/p/search/" + address;
    window.open(url, '_blank');
  });
}

function calculateAbilityScore(selector) {
  const selectedPollutant = [];

  selector.each(function() {
    const pollutant_id = $(this).val();
    selectedPollutant.push({"pollutant_id": pollutant_id});
  });

  if (selectedPollutant.length === 0) return alert("항목을 선택해 주세요.");

  $.ajax({
    url: /*[[@{/document/score/calculation}]]*/ '',
    type: 'POST',
    contentType: 'application/json',
    data: JSON.stringify(selectedPollutant),
    success: function(response) {
      const score = response.score;
      $('#score').html(score);
    },
    error: function() {
      alert("error");
    }
  });
}

function getNoteOfStack(note) {
  const memo = $('#noteOfStack');

  memo.empty();
  memo.prop('readonly', true);
  memo.val(note);
}

function getHistory(histories) {
  const tbody = $('#table tbody');
  tbody.empty();

  histories.forEach(history => {
    const date = new Date(history.measureDate);

    const localDate = new Date(date.getTime() - date.getTimezoneOffset() * 60000);

    const innerHtml = `
          <tr>
            <td>` + localDate.toISOString().split('T')[0] + `</td>
            <td>${history.pollutantIds}</td>
            <td>${history.teamName}</td>
          </tr>
        `;
    tbody.append(innerHtml);
  });
}

function uploadMeasurementExcelData(selector) {
  const isValidAValue = (value) => {
    return value === "" || !isNaN(value);
  };

  const validCycles = ["1회/월", "2회/월", "1회/분기", "1회/반기", "1회/년", "미측정"];

  const isValidCycle = (value) => {
    return validCycles.includes(value);
  };

  $(selector).on('change', function (e) {
    const file = e.target.files[0];

    if (!file) {
      console.error("파일을 선택해주세요.");
      return;
    }

    const reader = new FileReader();

    reader.readAsArrayBuffer(file);

    reader.onload = function (e) {
      const data = new Uint8Array(e.target.result);
      const workbook = XLSX.read(data, {type: "array"});

      const sheet = workbook.Sheets[workbook.SheetNames[0]];
      let stackData = XLSX.utils.sheet_to_json(sheet);

      const tbody = $('#tbody');

      const renderTable = () => {
        tbody.empty();
        const duplicateMap = new Map();

        stackData.forEach((row, index) => {
          const tr = $('<tr class="table-primary"></tr>');

          const stack = row.stack ?? "";
          const pollutant = row.pollutant ?? "";
          const aValue = row.aValue ?? "";
          const cycle = row.cycle ?? "";

          const key = `${stack}--${pollutant}`;

          if (duplicateMap.has(key)) {
            duplicateMap.get(key).push(index);
          } else {
            duplicateMap.set(key, [index]);
          }

          let aValueClass = "";
          if (!isValidAValue(aValue)) {
            aValueClass = "table-danger";
          }

          let cycleClass = "";
          if (!isValidCycle(cycle)) {
            cycleClass = "table-danger";
          }

          tr.append(`<td data-role="stack_name">${stack}</td>`);
          tr.append(`<td data-role="pollutant_name">${pollutant}</td>`);
          tr.append(`<td class="${aValueClass}" data-role="allow_value">${aValue}</td>`);
          tr.append(`<td class="${cycleClass}" data-role="cycle_type">${cycle}</td>`);
          tr.append(`<td>
                        <button class="btn btn-danger btn-sm delete-btn" data-role="delete" data-index="${index}">삭제</button>
                      </td>`);

          tbody.append(tr);
        });

        duplicateMap.forEach((indices) => {
          if (indices.length > 1) {
            indices.forEach((i) => {
              tbody.find("tr").eq(i).removeClass("table-primary");
              tbody.find("tr").eq(i).addClass("table-danger");
            });
          }
        });

        $('[data-role="delete"]').on('click', function () {
          const index = $(this).data('index');
          stackData.splice(index, 1);
          renderTable();
        });
      }

      renderTable();
    };
  });
}

function loadToast(result, msg) {
  if (!result) return;

  const {
    successMsg = "default",
    failedMsg = "default"
  } = msg;

  if (result === 'success') {
    const toastElement = $('#successToast');
    toastElement.find('div.toast-body').text(successMsg);
    const toast = new bootstrap.Toast(toastElement);
    toast.show();
  } else if (result === 'fail') {
    const toastElement = $('#failToast');
    toastElement.find('div.toast-body').text(failedMsg);
    const toast = new bootstrap.Toast(toastElement);
    toast.show();
  }
}

// ------------------------
// ------------------------
// Crud Functions
// ------------------------

function viewModifyToast() {
  const msg = {
    successMsg: '수정 되었습니다.',
    failedMsg: '수정에 실패 하였습니다.'
  }

  const modifyResult = sessionStorage.getItem('modifyResult');

  if (modifyResult) {
    loadToast(modifyResult, msg);
    sessionStorage.removeItem('modifyResult');
  }
}

function viewAddMeasurementToast(result) {
  if(!result) return;

  const msg = {
    successMsg: '측정 항목이 추가 되었습니다.',
    failedMsg: '측정 항목 추가에 실패 하였습니다.',
  }

  const addResult = sessionStorage.getItem('addResult');

  if (addResult) {
    loadToast(addResult, msg);
    sessionStorage.removeItem('addResult');
  }
}

function businessModifyHandler(options) {
  const {
    btnId,
    selector,
    url,
  } = options;

  let isReadonly = selector.find('input').prop('readonly');

  if(isReadonly) {
    selector.find('input').prop('readonly', false);
    btnId.html('저장');
    return;
  }

  if (!confirm('수정 하시겠습니까?')) return;

  const form = selector[0];

  if (!form.checkValidity()) {
    $(form).addClass('was-validated');
    return;
  }

  const information = {};

  selector.find('input').each(function(){
    let name = String($(this).attr('name'));
    information[name] = $(this).val();
  });

  const msg = {
    successMsg: '수정 되었습니다.',
    failedMsg: '수정에 실패 하였습니다.'
  }

  $.ajax({
    type: 'PATCH',
    url: url,
    headers : { 'Content-Type': 'application/json'},
    dataType : 'text',
    data : JSON.stringify(information),
    success: function() {
      sessionStorage.setItem('modifyResult', 'success');
      location.reload();
    },
    error: function() {
      loadToast('fail', msg);
    }
  });
}

function viewCompleteToast() {
  const msg = {
    successMsg: '일정이 완료 처리 되었습니다.',
    failedMsg: '작업에 실패 하였습니다.'
  }

  const completeResult = sessionStorage.getItem('completeResult');

  if (completeResult) {
    loadToast(completeResult, msg);
    sessionStorage.removeItem('completeResult');
  }
}

function viewDeleteToast() {
  const msg = {
    successMsg: '삭제 되었습니다.',
    failedMsg: '삭제에 실패 하였습니다.'
  }

  const deleteResult = sessionStorage.getItem('deleteResult');

  if (deleteResult) {
    loadToast(deleteResult, msg);
    sessionStorage.removeItem('deleteResult');
  }
}

function businessDeleteHandler(options) {
  const {
    selector,
    closestTag,
    dataAttr,
    idKey,
    url,
  } = options;

  if (!confirm("삭제 후 복구가 불가능 합니다. 정말로 삭제 하시겠습니까?")) return;
  const selectedItems = [];
  $(selector).each(function() {
    const id_value = $(this).closest(closestTag).attr(dataAttr);
    if (id_value) {
      const item = {};
      item[idKey] = id_value;
      selectedItems.push(item);
    }
  });
  if (selectedItems.length === 0) return loadToast('fail', { failedMsg : "선택된 항목이 없습니다."});

  const msg = {
    successMsg: '삭제 되었습니다.',
    failedMsg: '삭제에 실패 하였습니다.'
  }

  $.ajax({
    url: url,
    type: 'DELETE',
    contentType: 'application/json',
    data: JSON.stringify(selectedItems),
    success: function() {
      sessionStorage.setItem('deleteResult', 'success');
      location.reload();
    },
    error: function() {
      loadToast('fail', msg);
    }
  });
}

// ------------------------
// ------------------------
// Stack Measurement List View
// ------------------------
const orderCycle = ["monthly", "quarterly", "semiannual", "annual", "twiceamonth", "onceinfebruary", "additional"];
const orderMethod = ["먼지", "현장측정", "흡수액", "카트리지", "흡착관(T)", "흡착관(A)", "중금속", "수은", "비소", "테드라백"];
const convert = {
  "nomeasure": "미측정",
  "monthly": "월 / 1회",
  "quarterly": "분기 1회",
  "semiannual" : "반기 / 1회",
  "annual" : "연 / 1회",
  "twiceamonth": "월 / 2회",
  "onceinfebruary": "2월 / 1회",
  "additional": "추가 측정",
}

function methodList(pollutants) {
  const result = {};
  orderCycle.forEach(cycle => {
    const method = [];
    pollutants.forEach(poll => {
      if (poll.cycleType === cycle) {
        method.push(poll.method);
      }
    });
    if (method.length > 0) {
      result[cycle] = method;
    }
  });

  return result;
}

function sortCycle(pollutants) {
  const cycleType = {};
  pollutants.forEach(item => {
    const cycle = item.cycleType;
    cycleType[cycle] = convert[cycle];
  });
  return orderCycle.filter(key => cycleType.hasOwnProperty(key));
}

// {monthly:['먼지', '중금속'], annual:['중금속']}

function createPollutantListView(options) {
  const {
    pollutants,
    parentId,
  } = options;
  const parentDiv = $(parentId);
  const sortedCycle = sortCycle(pollutants);
  const methods = methodList(pollutants);

  parentDiv.empty();

  sortedCycle.forEach(key => {
    const childDiv = `
            <div class="border p-4 mx-2 flex-grow-1 shadow-sm rounded bg-body-tertiary">
              <span class="badge text-bg-primary">` + convert[key] + `</span>
              <div id="` + key +  `" class="my-3 d-flex flex-column"></div>
            </div>`;
    parentDiv.append(childDiv)
  });

  for (const key in methods) {
    const parentDiv = $('#' + key);
    const uniqueValues = [... new Set(methods[key])];
    const sortedValues = orderMethod.filter(key => uniqueValues.includes(key));

    sortedValues.forEach(value => {
      const childDiv = `
              <div class="m-1">
                <span class="badge text-bg-primary">` + value + `</span>
                <div data-method="` + value + `"></div>
              </div>
             `;
      parentDiv.append(childDiv);
    });
  }

  pollutants.forEach(item => {
    const cycle = item.cycleType;
    const id = '#' + cycle;
    const value = item.method;
    const tag = $(id);
    const aValue = item.allowValue != null ? item.allowValue + ' ppm' : '';
    const color = item.isCompleted ? 'green' : 'red';

    const childDiv =
               `<div class="form-check form-check-inline m-1" style="width: 300px;" data-stack-measurement-id="${item.stackMeasurementId}">
                  <input class="form-check-input" type="checkbox" value="${item.pollutantId}" id="${item.pollutantId}">
                  <label class="form-check-label" for="${item.pollutantId}"><span style="color: ${color}">${item.pollutantNameKR}</span> <small style="color: saddlebrown">${aValue}</small></label>
                </div>`;

    tag.find(`div[data-method="${value}"]`).append(childDiv)
  })
}


$(document).ready(function() {
  viewDeleteToast();
  viewModifyToast();
  viewCompleteToast();
});