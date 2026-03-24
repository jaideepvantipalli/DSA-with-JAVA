#include <stdio.h>
#include <stdlib.h>

struct Node{
    int data;
    struct Node *next;
};

struct Node* moveLast(struct Node *head){

    if(head==NULL || head->next==NULL)
        return head;

    if(head->next->next==NULL){
        struct Node *last=head->next;
        head->next=NULL;
        last->next=head;
        return last;
    }

    struct Node *newHead=moveLast(head->next);
    return newHead;
}

void display(struct Node *head){

    while(head!=NULL){
        printf("%d -> ",head->data);
        head=head->next;
    }
    printf("NULL\n");
}

int main(){

    struct Node *head=NULL,*temp=NULL,*newNode;
    int data,choice;

    do{
        newNode=(struct Node*)malloc(sizeof(struct Node));

        printf("Enter number: ");
        scanf("%d",&data);

        newNode->data=data;
        newNode->next=NULL;

        if(head==NULL)
            head=temp=newNode;
        else{
            temp->next=newNode;
            temp=newNode;
        }

        printf("Add another node? (1=Yes 0=Exit): ");
        scanf("%d",&choice);

    }while(choice==1);

    printf("Original List:\n");
    display(head);

    head=moveLast(head);

    printf("After Moving Last Node to Front:\n");
    display(head);
}